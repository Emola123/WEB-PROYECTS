package com.ejercicio.WebProyect.controllers;

import com.ejercicio.WebProyect.entities.Aereolinea;
import com.ejercicio.WebProyect.service.AereolineaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/aereolineas")
public class AereolineaController {
    private final AereolineaService aereolineaService;

    public AereolineaController(AereolineaService aereolineaService) {
        this.aereolineaService = aereolineaService;
    }

    @GetMapping("/{id}")
    public Optional<Aereolinea> buscarAereolineaId(@PathVariable Long id) {
        return aereolineaService.buscarAereolineaId(id);
    }

    @GetMapping
    public List<Aereolinea> listarAereolineas() {
        return aereolineaService.listarAereolineas();
    }

    @GetMapping("/nombre")
    public Optional<Aereolinea> buscarPorNombre(@RequestParam("nombre") String nombre) {
        return aereolineaService.buscarPorNombre(nombre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aereolinea> actualizarAereolinea(@PathVariable Long id, @RequestBody Aereolinea aereolinea) {
        return ResponseEntity.ok(aereolineaService.actualizarAereolinea(id, aereolinea));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAereolinea(@PathVariable Long id) {
        aereolineaService.eliminarAereolinea(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public Aereolinea guardarAereolinea(@RequestBody Aereolinea aereolinea) {
        return aereolineaService.guardarAereolinea(aereolinea);
    }

}
