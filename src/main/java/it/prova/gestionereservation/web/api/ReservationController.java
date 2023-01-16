package it.prova.gestionereservation.web.api;

import it.prova.gestionereservation.dto.DataDTO;
import it.prova.gestionereservation.dto.ReservationDTO;
import it.prova.gestionereservation.model.Reservation;
import it.prova.gestionereservation.service.ReservationService;
import it.prova.gestionereservation.web.api.exception.IdNotNullForInsertException;
import it.prova.gestionereservation.web.api.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<ReservationDTO> getAll() {
        return ReservationDTO.createListReservationDTOFromModelList(reservationService.listAllReservation());
    }

    @PostMapping
    public ReservationDTO createNew(@Valid @RequestBody ReservationDTO reservationInput) {
        if (reservationInput.getId() != null)
            throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");
        Reservation reservation = reservationService.inserisciNuovo(reservationInput.buildReservationModel());
        return ReservationDTO.buildReservationDTOFromModel(reservation);
    }

    @GetMapping("/{id}")
    public ReservationDTO findById(@PathVariable(value = "id", required = true) long id) {
        Reservation reservation = reservationService.caricaSingoloReservation(id);
        if (reservation == null)
            throw new NotFoundException("Room not found con id: " + id);
        return ReservationDTO.buildReservationDTOFromModel(reservation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id", required = true) long id) {
        Reservation reservation = reservationService.caricaSingoloReservation(id);
        if (reservation == null)
            throw new NotFoundException("Room not found con id: " + id);
        reservationService.rimuovi(id);
    }

    @PostMapping("/search")
    public List<Long> search(@Valid @RequestBody DataDTO dataInput){
        return ReservationDTO
                .createListReservationDTOFromModelList(reservationService.findByDatacreazione(dataInput.getDatainizio(), dataInput.getDatafine()))
                .stream()
                .map(ReservationDTO::getId).collect(Collectors.toList());

    }
}
