package com.ejercicio.WebProyect.service;

import com.ejercicio.WebProyect.entities.Pasajero;
import com.ejercicio.WebProyect.entities.Reserva;
import com.ejercicio.WebProyect.entities.Vuelo;
import com.ejercicio.WebProyect.repository.PasajeroRepository;
import com.ejercicio.WebProyect.repository.PasaporteRepository;
import com.ejercicio.WebProyect.repository.ReservaRepository;
import com.ejercicio.WebProyect.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService {
    private final VueloRepository vueloRepository;
    private final PasajeroRepository pasajeroRepository;
    private final ReservaRepository reservaRepository;
    private final PasaporteRepository pasaporteRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository, PasajeroRepository pasajeroRepository, ReservaRepository reservaRepository, PasaporteRepository pasaporteRepository) {
        this.vueloRepository = vueloRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.reservaRepository = reservaRepository;
        this.pasaporteRepository = pasaporteRepository;
    }

    public List<Vuelo> listarVuelos() {
        return vueloRepository.findAll();
    }

    public Optional<Vuelo> buscarVueloPorId(Long id) {
        return vueloRepository.findById(id);
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


    public Vuelo actualizarVuelo(Long id, Vuelo vueloActualizado) {
        Vuelo vueloExistente = vueloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        vueloActualizado.setId(vueloExistente.getId());

        if (vueloActualizado.getReservas() != null) {
            for (Reserva reserva : vueloActualizado.getReservas()) {
                reserva.setVuelo(vueloActualizado);
                if(reserva.getPasajero() != null){
                    pasajeroRepository.save(reserva.getPasajero());
                }
                reserva.setPasajero(reserva.getPasajero());
                if(reserva.getPasajero().getPasaporte() != null){
                    pasaporteRepository.save(reserva.getPasajero().getPasaporte());
                }
                reserva.getPasajero().setPasaporte(reserva.getPasajero().getPasaporte());
            }
            vueloExistente.setReservas(vueloActualizado.getReservas());
        }
        return vueloRepository.save(vueloActualizado);
    }



    public void eliminarVuelo(Long id){
        vueloRepository.deleteById(id);
    }

    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }
}
