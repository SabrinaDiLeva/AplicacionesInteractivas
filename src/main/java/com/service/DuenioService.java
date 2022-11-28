package com.service;

import com.dto.DuenioDTO;
import com.model.Duenio;
import com.model.Persona;
import com.model.Unidad;
import com.repository.IDuenioRepository;
import com.repository.IPersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class DuenioService implements IService<Duenio,DuenioDTO> {
    private IDuenioRepository iDuenioRepository;
    private IPersonaRepository iPersonaRepository;

    @Autowired
    public DuenioService(IDuenioRepository iDuenioRepository, IPersonaRepository iPersonaRepository) {
        this.iDuenioRepository = iDuenioRepository;
        this.iPersonaRepository=iPersonaRepository;

    }

    @Override
    public List<Duenio> listar() {
        return iDuenioRepository.findAll();
    }

    @Override
    public Duenio guardar(DuenioDTO duenio) {
        Persona persona = iPersonaRepository.findById(duenio.getPersona()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Duenio d = duenio.newDuenio(persona);
        return iDuenioRepository.save(d);
    }

    @Override
    public Duenio buscar(Long id) {
        return iDuenioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iDuenioRepository.deleteById(id);
    }

    @Override
    public Duenio modificar(Long id, DuenioDTO dto) {
        Duenio duenio = this.buscar(id);
        return this.guardar(dto.update(duenio));
    }

    /*public List<Duenio> listarPorIdEdificio(Long id) {
        List<Duenio> duenios=iDuenioRepository.findAll();
        List<Duenio> dueniosDelEdificio= new ArrayList<>();
        for(Duenio duenio : duenios){
            System.out.print("---------------------DUENIO: "+duenio.getId());
            List<Unidad> unidades = (List<Unidad>) duenio.getUnidades();
            for(Unidad unidad : unidades){
                System.out.print("---------------------UNIDAD: "+unidad.getId());
                System.out.print("---------------------EDIFICIO: "+unidad.getEdificio().getId());
                if(unidad.getEdificio().getId()==id){
                    dueniosDelEdificio.add(duenio);
                }
            }
        } 
        return dueniosDelEdificio;
    }*/
}