package com.ejercicio.WebProyect.repository;

import com.ejercicio.WebProyect.entities.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
    Optional<Pasajero> findByNombre(String nombre);
}
