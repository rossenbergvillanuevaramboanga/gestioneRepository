package it.prova.gestionereservation.repository.reservation;

import it.prova.gestionereservation.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
