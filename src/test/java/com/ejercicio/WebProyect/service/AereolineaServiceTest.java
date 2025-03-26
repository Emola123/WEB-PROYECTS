package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Aereolinea;
import com.ejercicio.WebProyect.repository.AereolineaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AereolineaServiceTest {

    @Mock
    private AereolineaRepository aereolineaRepository;

    @InjectMocks
    private AereolineaService aereolineaService;

    @Test
    void guardarAereolinea() {
        Aereolinea aereolinea = new Aereolinea(4L, "Aereolinea", null);
        when(aereolineaRepository.save(any(Aereolinea.class))).thenReturn(aereolinea);

        Aereolinea aereolineaCreada = aereolineaService.guardarAereolinea(aereolinea);

        assertNotNull(aereolineaCreada.getId());
        assertEquals("Aereolinea", aereolineaCreada.getNombre());
        assertNull(aereolineaCreada.getVuelos());
        verify(aereolineaRepository, times(1)).save(aereolinea);
    }

    @Test
    void buscarAereolineaNombre() {
        Aereolinea aereolinea = new Aereolinea(4L, "Aereolinea", null);
        when(aereolineaRepository.findByNombre("Aereolinea")).thenReturn(Optional.of(aereolinea));

        Optional<Aereolinea> foundAereolinea = aereolineaService.buscarPorNombre("Aereolinea");

        assertTrue(foundAereolinea.isPresent());
        assertEquals("Aereolinea", foundAereolinea.get().getNombre());
        verify(aereolineaRepository, times(1)).findByNombre("Aereolinea");
    }

    @Test
    void buscarAereolineaNombre_NotFound() {
        when(aereolineaRepository.findByNombre("AeroSky")).thenReturn(Optional.empty());

        Optional<Aereolinea> foundAereolinea = aereolineaService.buscarPorNombre("AeroSky");
        assertFalse(foundAereolinea.isPresent());
        verify(aereolineaRepository, times(1)).findByNombre("AeroSky");
    }
}