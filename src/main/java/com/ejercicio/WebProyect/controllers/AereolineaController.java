package com.ejercicio.WebProyect.controllers;

import com.ejercicio.WebProyect.entities.Aereolinea;
import com.ejercicio.WebProyect.service.AereolineaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aereolineas")
public class AereolineaController {
    private final AereolineaService aereolineaService;

    public AereolineaController(AereolineaService aereolineaService) {
        this.aereolineaService = aereolineaService;
    }

    @GetMapping
    public List<Aereolinea> listarAereolineas() {
        return aereolineaService.listarAereolineas();
    }

    @GetMapping("/nombre")
    public Optional<Aereolinea> buscarPorNombre(@RequestParam("nombre") String nombre) {
        return aereolineaService.buscarPorNombre(nombre);
    }

    @PostMapping
    public Aereolinea guardarAereolinea(@RequestBody Aereolinea aereolinea) {
        return aereolineaService.guardarAereolinea(aereolinea);
    }

}
