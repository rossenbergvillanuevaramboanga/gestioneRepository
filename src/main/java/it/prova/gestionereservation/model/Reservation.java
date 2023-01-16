package it.prova.gestionereservation.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "datacreazione")
    private LocalDate dataCreazione;

}
