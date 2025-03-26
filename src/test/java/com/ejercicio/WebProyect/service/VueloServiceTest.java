package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Vuelo;
import com.ejercicio.WebProyect.repository.VueloRepository;
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
class VueloServiceTest {

    @Mock
    private VueloRepository vueloRepository;

    @InjectMocks
    private VueloService vueloService;

    @Test
    void listarVuelos() {
        Vuelo vuelos = new Vuelo(1L, "AV123", "Bogotá", "Bucaramanga", null, null);
        when(vueloRepository.findAll()).thenReturn(List.of(vuelos));

        List<Vuelo> foundVuelos = vueloService.listarVuelos();
        assertNotNull(foundVuelos);
        verify(vueloRepository, times(1)).findAll();
    }

    @Test
    void buscarCodigoVuelo() {
        Vuelo vuelo = new Vuelo(1L, "AV123", "Bogotá", "Bucaramanga", null, null);
        when(vueloRepository.findByCodigo("AV123")).thenReturn(Optional.of(vuelo));

        Vuelo foundVuelo = vueloService.buscarCodigoVuelo("AV123")
                        .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        assertNotNull(foundVuelo);
        assertEquals("AV123", foundVuelo.getCodigo());
        verify(vueloRepository, times(1)).findByCodigo("AV123");
    }

    @Test
    void buscarOrigenVuelo() {
        Vuelo vuelo = new Vuelo(1L, "AV123", "Bogotá", "Bucaramanga", null, null);
        when(vueloRepository.findByOrigen("Bogotá")).thenReturn(Optional.of(vuelo));

        Vuelo foundVuelo = vueloService.buscarOrigenVuelo("Bogotá")
                        .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        assertNotNull(foundVuelo);
        assertEquals("Bogotá", foundVuelo.getOrigen());
        verify(vueloRepository, times(1)).findByOrigen("Bogotá");
    }

    @Test
    void buscarDestinoVuelo() {
        Vuelo vuelo = new Vuelo(1L, "AV123", "Bogotá", "Bucaramanga", null, null);
        when(vueloRepository.findByDestino("Bucaramanga")).thenReturn(Optional.of(vuelo));

        Vuelo foundVuelo = vueloService.buscarDestinoVuelo("Bucaramanga")
                        .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        assertNotNull(foundVuelo);
        assertEquals("Bucaramanga", foundVuelo.getDestino());
        verify(vueloRepository, times(1)).findByDestino("Bucaramanga");
    }

    @Test
    void guardarVuelo() {
        Vuelo vuelo = new Vuelo(1L, "AV123", "Bogotá", "Bucaramanga", null, null);
        when(vueloRepository.save(any(Vuelo.class))).thenReturn(vuelo);

        Vuelo foundVuelo = vueloService.guardarVuelo(vuelo);

        assertNotNull(foundVuelo.getId());
        assertEquals(1L, foundVuelo.getId());
        assertEquals("AV123", foundVuelo.getCodigo());
        assertEquals("Bogotá", foundVuelo.getOrigen());
        assertEquals("Bucaramanga", foundVuelo.getDestino());
        assertNull(foundVuelo.getAereolinea());
        assertNull(foundVuelo.getReservas());
        verify(vueloRepository, times(1)).save(vuelo);

    }
}