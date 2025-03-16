package com.ejercicio.WebProyect.repository;

import com.ejercicio.WebProyect.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    @Override
    Optional<Vuelo> findById(Long id);

    Optional<Vuelo> findByCodigo(String codigo);

    Optional<Vuelo> findByOrigen(String origen);
    Optional<Vuelo> findByDestino(String destino);


}
