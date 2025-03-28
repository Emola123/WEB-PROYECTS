package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Pasajero;
import com.ejercicio.WebProyect.entities.Pasaporte;
import com.ejercicio.WebProyect.repository.PasajeroRepository;
import com.ejercicio.WebProyect.repository.PasaporteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PasaporteService {
    private final PasaporteRepository pasaporteRepository;
    private final PasajeroRepository pasajeroRepository;

    public PasaporteService(PasaporteRepository pasaporteRepository, PasajeroRepository pasajeroRepository) {
        this.pasaporteRepository = pasaporteRepository;
        this.pasajeroRepository = pasajeroRepository;
    }

    public List<Pasaporte> listarPasaportes() {
        return pasaporteRepository.findAll();
    }

    public Optional<Pasaporte> buscarPorNumero(String numero) {
        return pasaporteRepository.findByNumero(numero);
    }

    public Optional<Pasaporte> buscarPorId(Long id) {
        return pasaporteRepository.findById(id);
    }

    public Pasaporte actualizarPasaporte(Long id, Pasaporte pasaporte) {
        Pasaporte existente = pasaporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pasaporte no encontrado"));
        existente.setNumero(pasaporte.getNumero());
        Pasajero actual = pasaporte.getPasajero();
        if(actual.getId() == null){
            actual = pasajeroRepository.save(actual);
        }
        existente.setPasajero(actual);
        return pasaporteRepository.save(existente);
    }

    public void eliminarPasaporte(Long id) {
        pasaporteRepository.deleteById(id);
    }

    public Pasaporte guardarPasaporte(Pasaporte pasaporte) {
        return pasaporteRepository.save(pasaporte);
    }

}
