package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Aereolinea;
import com.ejercicio.WebProyect.entities.Vuelo;
import com.ejercicio.WebProyect.repository.AereolineaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AereolineaService {
    private final AereolineaRepository aereolineaRepository;

    public AereolineaService(AereolineaRepository aereolineaRepository) {
        this.aereolineaRepository = aereolineaRepository;
    }

    public List<Aereolinea> listarAereolineas(){
        return aereolineaRepository.findAll();
    }

    public Optional<Aereolinea> buscarAereolineaId(Long id){
        return aereolineaRepository.findById(id);
    }

    public Optional<Aereolinea> buscarPorNombre(String nombre){
        return aereolineaRepository.findByNombre(nombre);
    }

    public Aereolinea actualizarAereolinea(Long id, Aereolinea aereolinea) {
        Aereolinea existente = aereolineaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aerolinea no encontrada"));
        existente.setNombre(aereolinea.getNombre());

        for(Vuelo vuelo : aereolinea.getVuelos()){
            vuelo.setAereolinea(existente);
        }

        existente.setVuelos(aereolinea.getVuelos());

        return aereolineaRepository.save(existente);
    }

    public void eliminarAereolinea(Long id) {
        aereolineaRepository.deleteById(id);
    }


    public Aereolinea guardarAereolinea(Aereolinea aereolinea){
        return aereolineaRepository.save(aereolinea);
    }
}
