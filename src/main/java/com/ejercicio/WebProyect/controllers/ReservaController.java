package com.ejercicio.WebProyect.controllers;

import com.ejercicio.WebProyect.entities.Reserva;
import com.ejercicio.WebProyect.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.listarReservas();
    }

    @GetMapping("/codigo")
    public Optional<Reserva> getReservaByCodigo(@RequestParam("codigo") String codigo) {
        return reservaService.buscarPorCodigo(codigo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.actualizarReserva(id, reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return reservaService.guardarReserva(reserva);
    }
}
