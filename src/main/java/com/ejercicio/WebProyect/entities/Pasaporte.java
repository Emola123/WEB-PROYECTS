package com.ejercicio.WebProyect.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pasaportes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pasaporte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numero;

    @OneToOne
    @JoinColumn(name = "id_pasaporte")
    @JsonBackReference
    private Pasajero pasajero;

}
