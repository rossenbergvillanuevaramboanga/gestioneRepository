package it.prova.gestionereservation.service;

import it.prova.gestionereservation.model.Reservation;
import it.prova.gestionereservation.repository.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)

public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository repository;

    @Override
    public List<Reservation> listAllReservation() {
        return (List<Reservation>) repository.findAll();
    }

    @Override
    public Reservation caricaSingoloReservation(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Reservation aggiorna(Reservation reservationInstance) {
        Reservation reservationReloaded = repository.findById(reservationInstance.getId()).orElse(null);
        if(reservationReloaded == null) throw new RuntimeException("Element not found");
        reservationReloaded.setDataCreazione(reservationInstance.getDataCreazione());
        return repository.save(reservationReloaded);
    }

    @Transactional
    public Reservation inserisciNuovo(Reservation reservationInstance) {
        return repository.save(reservationInstance);
    }

    @Transactional
    public void rimuovi(Long idToRemove) {
        Reservation reservationReloaded = repository.findById(idToRemove).orElse(null);
        if(reservationReloaded == null) throw new RuntimeException("Element not found");
        repository.deleteById(idToRemove);
    }

    @Override
    public List<Reservation> findByDatacreazione(LocalDate datainizio, LocalDate datafine) {
        return repository.findAllByDataCreazioneBetween(datainizio,datafine);
    }
}
