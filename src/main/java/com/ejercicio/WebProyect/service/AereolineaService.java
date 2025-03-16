package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Aereolinea;
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

    public Optional<Aereolinea> buscarPorNombre(String nombre){
        return aereolineaRepository.findByNombre(nombre);
    }


    public Aereolinea guardarAereolinea(Aereolinea aereolinea){
        return aereolineaRepository.save(aereolinea);
    }
}
