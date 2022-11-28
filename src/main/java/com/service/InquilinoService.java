package com.service;

import com.dto.InquilinoDTO;
import com.model.Inquilino;
import com.model.Persona;
import com.repository.IDuenioRepository;
import com.repository.IInquilinoRepository;
import com.repository.IPersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;
@Service
public class InquilinoService implements IService<Inquilino,InquilinoDTO> {
    private IInquilinoRepository iInquilinoRepository;
    private IPersonaRepository iPersonaRepository;

    @Autowired
    public InquilinoService(IInquilinoRepository iInquilinoRepository, IPersonaRepository iPersonaRepository) {
        this.iInquilinoRepository = iInquilinoRepository;
        this.iPersonaRepository=iPersonaRepository;

    }

    @Override
    public List<Inquilino> listar() {
        return iInquilinoRepository.findAll();
    }

    @Override
    public Inquilino guardar(InquilinoDTO inquilino) {
        Persona persona = iPersonaRepository.findById(inquilino.getPersona()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Inquilino i = inquilino.newInquilino(persona);
        return iInquilinoRepository.save(i);
    }

    @Override
    public Inquilino buscar(Long id) {
        return iInquilinoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iInquilinoRepository.deleteById(id);
    }

    @Override
    public Inquilino modificar(Long id, InquilinoDTO dto) {
        Inquilino inquilino = this.buscar(id);
        return this.guardar(dto.update(inquilino));
    }
}