package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Pasajero;
import com.ejercicio.WebProyect.entities.Pasaporte;
import com.ejercicio.WebProyect.repository.PasajeroRepository;
import com.ejercicio.WebProyect.repository.PasaporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroService {
    private final PasajeroRepository pasajeroRepository;
    private final PasaporteRepository pasaporteRepository;

    public PasajeroService(PasajeroRepository pasajeroRepository, PasaporteRepository pasaporteRepository) {
        this.pasajeroRepository = pasajeroRepository;
        this.pasaporteRepository = pasaporteRepository;
    }

    public Optional<Pasajero> buscarPasajeroPorNombre(String nombre) {
        return pasajeroRepository.findByNombre(nombre);
    }

    public List<Pasajero> buscarPasajeros() {
        return pasajeroRepository.findAll();
    }

    public Pasajero actualizarPasajero(Long id, Pasajero pasajero) {
        Pasajero existente = pasajeroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));
        existente.setNombre(pasajero.getNombre());

        Pasaporte pasaporte = pasajero.getPasaporte();
        if(pasaporte.getId() == null) {
            pasaporte = pasaporteRepository.save(pasaporte);
        }
        existente.setPasaporte(pasaporte);
        return pasajeroRepository.save(existente);
    }

    public Optional<Pasajero> buscarPorId(Long id) {
        return pasajeroRepository.findById(id);
    }

    public void eliminarPasajero(Long id) {
        pasajeroRepository.deleteById(id);
    }


    public Pasajero guardarPasajero(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

}
