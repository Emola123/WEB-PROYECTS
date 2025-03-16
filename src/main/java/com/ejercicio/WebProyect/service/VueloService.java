package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Vuelo;
import com.ejercicio.WebProyect.repository.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService {
    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> listarVuelos() {
        return vueloRepository.findAll();
    }

    public Optional<Vuelo> buscarCodigoVuelo(String codigo){
        return vueloRepository.findByCodigo(codigo);
    }

    public Optional<Vuelo> buscarOrigenVuelo(String origen){
        return vueloRepository.findByOrigen(origen);
    }

    public Optional<Vuelo> buscarDestinoVuelo(String destino){
        return vueloRepository.findByDestino(destino);
    }

    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }
}
