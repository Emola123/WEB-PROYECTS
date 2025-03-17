package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Pasaporte;
import com.ejercicio.WebProyect.repository.PasaporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasaporteService {
    private final PasaporteRepository pasaporteRepository;

    public PasaporteService(PasaporteRepository pasaporteRepository) {
        this.pasaporteRepository = pasaporteRepository;
    }

    public List<Pasaporte> listarPasaportes() {
        return pasaporteRepository.findAll();
    }

    public Optional<Pasaporte> buscarPorNumero(String numero) {
        return pasaporteRepository.findByNumero(numero);
    }

    public Pasaporte actualizarPasaporte(Long id, Pasaporte pasaporte) {
        Pasaporte existente = pasaporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pasaporte no encontrado"));
        existente.setNumero(pasaporte.getNumero());
        existente.setPasajero(pasaporte.getPasajero());
        return pasaporteRepository.save(existente);
    }

    public void eliminarPasaporte(Long id) {
        pasaporteRepository.deleteById(id);
    }

    public Pasaporte guardarPasaporte(Pasaporte pasaporte) {
        return pasaporteRepository.save(pasaporte);
    }

}
