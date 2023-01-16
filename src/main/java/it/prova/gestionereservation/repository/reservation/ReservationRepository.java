package it.prova.gestionereservation.repository.reservation;

import it.prova.gestionereservation.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAllByDataCreazioneBetween(LocalDate datainizio, LocalDate datafine);
}
