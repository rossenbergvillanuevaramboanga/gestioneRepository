package it.prova.gestionereservation.service;

import it.prova.gestionereservation.model.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface ReservationService {
    public List<Reservation> listAllReservation();

    public Reservation caricaSingoloReservation(Long id);

    public Reservation aggiorna(Reservation reservationInstance);

    public Reservation inserisciNuovo(Reservation reservationInstance);

    public void rimuovi(Long idToRemove);

    public List<Reservation> findByDatacreazione(LocalDate datainizio, LocalDate datafine);
}
