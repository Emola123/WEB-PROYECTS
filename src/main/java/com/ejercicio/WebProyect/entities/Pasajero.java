package com.ejercicio.WebProyect.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pasajeros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToOne(mappedBy = "pasajero", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Pasaporte pasaporte;

    @OneToMany(mappedBy = "pasajero", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

}
