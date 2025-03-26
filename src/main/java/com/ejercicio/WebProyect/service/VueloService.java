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

    public Vuelo actualizarVuelo(Long id, Vuelo vuelo){
        Vuelo existente = vueloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        existente.setOrigen(vuelo.getOrigen());
        existente.setDestino(vuelo.getDestino());
        existente.setCodigo(vuelo.getCodigo());
        existente.setAereolinea(vuelo.getAereolinea());
        existente.setReservas(vuelo.getReservas());
        return vueloRepository.save(existente);
    }

    public void eliminarVuelo(Long id){
        vueloRepository.deleteById(id);
    }

    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }
}
