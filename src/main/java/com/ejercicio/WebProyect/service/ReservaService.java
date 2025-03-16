package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Reserva;
import com.ejercicio.WebProyect.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Optional<Reserva> buscarPorCodigo(String codigo) {
        return reservaRepository.findByCodigo(codigo);
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}
