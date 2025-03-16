package com.ejercicio.WebProyect.controllers;

import com.ejercicio.WebProyect.entities.Pasaporte;
import com.ejercicio.WebProyect.service.PasaporteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pasaportes")
public class PasaporteController {
    private final PasaporteService pasaporteService;

    public PasaporteController(PasaporteService pasaporteService) {
        this.pasaporteService = pasaporteService;
    }

    @GetMapping
    public List<Pasaporte> listarPasaportes() {
        return pasaporteService.listarPasaportes();
    }

    @GetMapping("/numero")
    public Optional<Pasaporte> buscarPorNumero(@RequestParam("numero") String numero) {
        return pasaporteService.buscarPorNumero(numero);
    }

    @PostMapping
    public Pasaporte guardarPasaporte(@RequestBody Pasaporte pasaporte) {
        return pasaporteService.guardarPasaporte(pasaporte);
    }
}
