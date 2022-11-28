package com.dto;
import java.io.Serializable;

import com.model.Imagen;
import com.model.Reclamo;

public class ImagenDTO implements Serializable {
    private Long id;
    private String url;
    private String tipo;
    private Long reclamoId;

    public ImagenDTO(){}
    public ImagenDTO(Long id, String url, String tipo, Long reclamoId){
        this.id=id;
        this.url=url;
        this.tipo=tipo;
        this.reclamoId=reclamoId;
    }
    public Imagen newImagen(Reclamo reclamo) {
        return new Imagen( this.id , this.url, this.tipo, reclamo);
    }

    public ImagenDTO update(Imagen imagen){
        Long reclamoId = ( this.reclamoId == null )? imagen.getReclamo().getId() : this.reclamoId;
        return new ImagenDTO(imagen.getId(),imagen.getUrl(),imagen.getTipo(),reclamoId);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String u) {
        this.url = u;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String u) {
        this.tipo = u;
    }
    public Long getReclamo() {
        return reclamoId;
    }

    public void setReclamo(Long p) {
        this.reclamoId = p;
    }
}
