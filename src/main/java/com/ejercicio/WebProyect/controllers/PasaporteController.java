package com.ejercicio.WebProyect.controllers;

import com.ejercicio.WebProyect.entities.Pasaporte;
import com.ejercicio.WebProyect.service.PasaporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
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

    @PutMapping("/{id}")
    public ResponseEntity<Pasaporte> actualizarPasaporte(@PathVariable Long id, @RequestBody Pasaporte pasaporte) {
        return ResponseEntity.ok(pasaporteService.actualizarPasaporte(id, pasaporte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPasaporte(@PathVariable Long id) {
        pasaporteService.eliminarPasaporte(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Pasaporte guardarPasaporte(@RequestBody Pasaporte pasaporte) {
        return pasaporteService.guardarPasaporte(pasaporte);
    }
}
