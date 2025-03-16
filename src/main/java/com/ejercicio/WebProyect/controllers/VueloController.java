package com.ejercicio.WebProyect.controllers;

import com.ejercicio.WebProyect.entities.Vuelo;
import com.ejercicio.WebProyect.service.VueloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {
    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public List<Vuelo> listarVuelos() {
        return vueloService.listarVuelos();
    }

    @GetMapping("/codigo")
    public Optional<Vuelo> buscarVueloCodigo(@RequestParam String codigo) {
        return vueloService.buscarCodigoVuelo(codigo);
    }

    @GetMapping("/origen")
    public Optional<Vuelo> buscarVueloOrigen(@RequestParam String origen) {
        return vueloService.buscarOrigenVuelo(origen);
    }

    @GetMapping("/destino")
    public Optional<Vuelo> buscarVueloDestino(@RequestParam String destino) {
        return vueloService.buscarDestinoVuelo(destino);
    }


    @PostMapping
    public Vuelo guardarVuelo(@RequestBody Vuelo vuelo) {
        return vueloService.guardarVuelo(vuelo);
    }
}
