package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Pasajero;
import com.ejercicio.WebProyect.repository.PasajeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroService {
    private final PasajeroRepository pasajeroRepository;

    public PasajeroService(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    public Optional<Pasajero> buscarPasajeroPorNombre(String nombre) {
        return pasajeroRepository.findByNombre(nombre);
    }

    public List<Pasajero> buscarPasajeros() {
        return pasajeroRepository.findAll();
    }

    public Pasajero guardarPasajero(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

}
