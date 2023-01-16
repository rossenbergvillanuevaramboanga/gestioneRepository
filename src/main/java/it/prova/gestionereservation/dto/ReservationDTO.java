package it.prova.gestionereservation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.prova.gestionereservation.model.Reservation;
import it.prova.gestionereservation.repository.reservation.ReservationRepository;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDTO {

    private Long id;
    private LocalDate dataCreazione;

    public Reservation buildReservationModel(){
        Reservation result = Reservation.builder().id(id).dataCreazione(dataCreazione).build();
        return result;
    }

    public static ReservationDTO buildReservationDTOFromModel(Reservation reservation){
        ReservationDTO result = ReservationDTO.builder().id(reservation.getId()).dataCreazione(reservation.getDataCreazione()).build();
        return result;
    }

    public static List<ReservationDTO> createListReservationDTOFromModelList(List<Reservation> reservationList){
        return reservationList.stream().map(reservation -> {
            return ReservationDTO.buildReservationDTOFromModel(reservation);
        }).collect(Collectors.toList());
    }
}
