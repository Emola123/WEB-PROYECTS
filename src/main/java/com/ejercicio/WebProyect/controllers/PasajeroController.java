package com.ejercicio.WebProyect.controllers;

import com.ejercicio.WebProyect.entities.Pasajero;
import com.ejercicio.WebProyect.entities.Pasaporte;
import com.ejercicio.WebProyect.service.PasajeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public Pasajero guardarPasajero(@RequestBody Pasajero pasajero) {
        return pasajeroService.guardarPasajero(pasajero);
    }


}
