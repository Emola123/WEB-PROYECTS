package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Pasaporte;
import com.ejercicio.WebProyect.repository.PasaporteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PasaporteServiceTest {
    @Mock
    private PasaporteRepository pasaporteRepository;

    @InjectMocks
    private PasaporteService pasaporteService;

    @Test
    void listarPasaportes() {
        Pasaporte pasaporte = new Pasaporte(1L, "AV123", null);
        when(pasaporteRepository.findAll()).thenReturn(List.of(pasaporte));

        List<Pasaporte> foundPasaportes = pasaporteService.listarPasaportes();

        assertNotNull(foundPasaportes);
        verify(pasaporteRepository, times(1)).findAll();
    }

    @Test
    void buscarPorNumero() {
        Pasaporte pasaporte = new Pasaporte(1L, "AV12345", null);
        when(pasaporteRepository.findByNumero("AV12345")).thenReturn(Optional.of(pasaporte));

        Pasaporte foundPasapote = pasaporteService.buscarPorNumero("AV12345")
                        .orElseThrow(() -> new RuntimeException("Pasaporte no encontrado"));

        assertNotNull(foundPasapote);
        assertEquals("AV12345", foundPasapote.getNumero());
        verify(pasaporteRepository, times(1)).findByNumero("AV12345");

    }

    @Test
    void buscarPorNumero_NotFound() {
        when(pasaporteRepository.findByNumero("AV1435")).thenReturn(Optional.empty());

        Optional<Pasaporte> foundPasapote = pasaporteService.buscarPorNumero("AV1435");
        assertFalse(foundPasapote.isPresent());
        verify(pasaporteRepository, times(1)).findByNumero("AV1435");
    }

    @Test
    void guardarPasaporte() {
        Pasaporte pasaporte = new Pasaporte(1L, "AV123", null);
        when(pasaporteRepository.save(any(Pasaporte.class))).thenReturn(pasaporte);

        Pasaporte foundPasaportes = pasaporteService.guardarPasaporte(pasaporte);

        assertNotNull(foundPasaportes.getId());
        assertEquals("AV123", foundPasaportes.getNumero());
        assertNull(foundPasaportes.getPasajero());
        verify(pasaporteRepository, times(1)).save(any(Pasaporte.class));

    }
}