package com.ejercicio.WebProyect.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_vuelo", insertable = false, updatable = false)
    private Long idVuelo;

    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    @JsonBackReference
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "id_pasajero") // Relación con Pasajero
    private Pasajero pasajero;

}
