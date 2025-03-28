package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Pasajero;
import com.ejercicio.WebProyect.entities.Reserva;
import com.ejercicio.WebProyect.repository.PasajeroRepository;
import com.ejercicio.WebProyect.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private final ReservaRepository reservaRepository;

    @Autowired
    private PasajeroRepository pasajeroRepository;

    public ReservaService(ReservaRepository reservaRepository, PasajeroRepository pasajeroRepository) {
        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
    }

    public Optional<Reserva> buscarReservaId(Long id) {
        return reservaRepository.findById(id);
    }

    public Optional<Reserva> buscarPorCodigo(String codigo) {
        return reservaRepository.findByCodigo(codigo);
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Reserva actualizarReserva(Long id, Reserva reserva) {
        Reserva existente = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        existente.setCodigo(reserva.getCodigo());
        existente.setVuelo(reserva.getVuelo());

        Pasajero pasajero = reserva.getPasajero();
        if (pasajero.getId() == null) {
            pasajero = pasajeroRepository.save(pasajero);
        }
        existente.setPasajero(pasajero);
        return reservaRepository.save(existente);
    }


    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}
