package com.ejercicio.WebProyect.repository;

import com.ejercicio.WebProyect.entities.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PasaporteRepository extends JpaRepository<Pasaporte, Long> {
    @Override
    List<Pasaporte> findAll();
    Optional<Pasaporte> findByNumero(String numero);
}
