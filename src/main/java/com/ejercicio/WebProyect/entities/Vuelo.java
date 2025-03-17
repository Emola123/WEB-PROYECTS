package com.ejercicio.WebProyect.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vuelos")
@Getter
@Setter
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @ManyToOne
    @JoinColumn(name = "aereolinea_id")
    @JsonBackReference
    private Aereolinea aereolinea;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Reserva> reservas;
}
