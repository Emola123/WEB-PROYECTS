package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Reserva;
import com.ejercicio.WebProyect.repository.ReservaRepository;
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
class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaService reservaService;

    @Test
    void buscarPorCodigo() {
        Reserva reserva = new Reserva(1L, 1L, "AV12345", null, null);
        when(reservaRepository.findByCodigo("AV12345")).thenReturn(Optional.of(reserva));

        Optional<Reserva> foundReserva = reservaService.buscarPorCodigo("AV12345");
        assertTrue(foundReserva.isPresent());
        assertEquals("AV12345", foundReserva.get().getCodigo());
        verify(reservaRepository, times(1)).findByCodigo("AV12345");
    }

    @Test
    void listarReservas() {
        Reserva reserva = new Reserva(1L, 1L, "AV12345", null, null);
        when(reservaRepository.findAll()).thenReturn(List.of(reserva));

        List<Reserva> foundReservas = reservaService.listarReservas();
        assertFalse(foundReservas.isEmpty());
        verify(reservaRepository, times(1)).findAll();
    }

    @Test
    void guardarReserva() {
        Reserva reserva = new Reserva(1L, 1L, "AV12345", null, null);
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        Reserva foundReserva = reservaService.guardarReserva(reserva);

        assertNotNull(foundReserva.getId());
        assertEquals(1L, foundReserva.getId());
        assertEquals(1L, foundReserva.getIdVuelo());
        assertEquals("AV12345", foundReserva.getCodigo());
        assertNull(foundReserva.getVuelo());
        assertNull(foundReserva.getPasajero());
        verify(reservaRepository, times(1)).save(reserva);
    }
}