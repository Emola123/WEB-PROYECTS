package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Pasajero;
import com.ejercicio.WebProyect.repository.PasajeroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PasajeroServiceTest {
    @Mock
    private PasajeroRepository pasajeroRepository;

    @InjectMocks
    private PasajeroService pasajeroService;

    @Test
    void buscarPasajeroPorNombre() {
        Pasajero pasajero = new Pasajero(1L, "Francisco", null, null);
        when(pasajeroRepository.findByNombre("Francisco")).thenReturn(Optional.of(pasajero));

        Optional<Pasajero> foundPasajero = pasajeroService.buscarPasajeroPorNombre("Francisco");

        assertTrue(foundPasajero.isPresent());
        assertEquals("Francisco", foundPasajero.get().getNombre());
        verify(pasajeroRepository, times(1)).findByNombre("Francisco");
    }

    @Test
    void buscarPasajeroPorNombre_NotFound() {
        when(pasajeroRepository.findByNombre("Raul")).thenReturn(Optional.empty());

        Optional<Pasajero> foundPasajero = pasajeroService.buscarPasajeroPorNombre("Raul");
        assertFalse(foundPasajero.isPresent());
        verify(pasajeroRepository, times(1)).findByNombre("Raul");
    }

    @Test
    void buscarPasajeros() {
        Pasajero pasajeros = new Pasajero(1L, "Francisco", null, null);
        when(pasajeroRepository.findAll()).thenReturn(List.of(pasajeros));

        List<Pasajero> foundPasajeros = pasajeroService.buscarPasajeros();

        assertNotNull(foundPasajeros);
        verify(pasajeroRepository, times(1)).findAll();
    }

    @Test
    void guardarPasajero() {
        Pasajero pasajero = new Pasajero(1L, "Francisco", null, null);
        when(pasajeroRepository.save(any(Pasajero.class))).thenReturn(pasajero);

        Pasajero pasajeroCreado =  pasajeroService.guardarPasajero(pasajero);

        assertNotNull(pasajeroCreado.getId());
        assertEquals("Francisco", pasajeroCreado.getNombre());
        assertNull(pasajeroCreado.getPasaporte());
        assertNull(pasajeroCreado.getReservas());
        verify(pasajeroRepository, times(1)).save(pasajero);
    }
}