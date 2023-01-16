package it.prova.gestionereservation.service;

import it.prova.gestionereservation.model.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> listAllRoom();

    public Reservation caricaSingoloRoom(Long id);

    public Reservation aggiorna(Reservation reservationInstance);

    public Reservation inserisciNuovo(Reservation reservationInstance);

    public void rimuovi(Long idToRemove);
}
