package com.service;

import com.dto.ImagenDTO;
import com.model.Imagen;
import com.model.Reclamo;
import com.repository.IImagenRepository;
import com.repository.IReclamoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;
@Service
public class ImagenService implements IService<Imagen,ImagenDTO> {
    private IImagenRepository iImagenRepository;
    private IReclamoRepository iReclamoRepository;

    @Autowired
    public ImagenService(IImagenRepository iImagenRepository, IReclamoRepository iReclamoRepository) {
        this.iImagenRepository = iImagenRepository;
        this.iReclamoRepository=iReclamoRepository;

    }

    @Override
    public List<Imagen> listar() {
        return iImagenRepository.findAll();
    }

    @Override
    public Imagen guardar(ImagenDTO Imagen) {
        Reclamo reclamo = iReclamoRepository.findById(Imagen.getReclamo()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Imagen i = Imagen.newImagen(reclamo);
        return iImagenRepository.save(i);
    }

    @Override
    public Imagen buscar(Long id) {
        return iImagenRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iImagenRepository.deleteById(id);
    }

    @Override
    public Imagen modificar(Long id, ImagenDTO dto) {
        Imagen Imagen = this.buscar(id);
        return this.guardar(dto.update(Imagen));
    }
}