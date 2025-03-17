package com.ejercicio.WebProyect.controllers;

import com.ejercicio.WebProyect.entities.Pasajero;
import com.ejercicio.WebProyect.service.PasajeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pasajeros")
public class PasajeroController {
    private final PasajeroService pasajeroService;

    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @GetMapping
    public List<Pasajero> buscarPasajeros() {
        return pasajeroService.buscarPasajeros();
    }

    @GetMapping("/nombre")
    public Optional<Pasajero> buscarPasajero(@RequestParam("nombre") String nombre) {
        return pasajeroService.buscarPasajeroPorNombre(nombre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> actualizarPasajero(@PathVariable Long id, @RequestBody Pasajero pasajero) {
        return ResponseEntity.ok(pasajeroService.actualizarPasajero(id, pasajero));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPasajero(@PathVariable Long id) {
        pasajeroService.eliminarPasajero(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Pasajero guardarPasajero(@RequestBody Pasajero pasajero) {
        return pasajeroService.guardarPasajero(pasajero);
    }


}
