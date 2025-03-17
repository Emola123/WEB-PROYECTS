package com.ejercicio.WebProyect.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "aereolineas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aereolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "aereolinea", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Vuelo> vuelos;
}
