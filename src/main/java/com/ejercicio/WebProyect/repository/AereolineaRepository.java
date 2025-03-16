package com.ejercicio.WebProyect.repository;

import com.ejercicio.WebProyect.entities.Aereolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AereolineaRepository extends JpaRepository<Aereolinea, Long> {
    @Override
    Optional<Aereolinea> findById(Long aLong);

    Optional<Aereolinea> findByNombre(String nombre);
}
