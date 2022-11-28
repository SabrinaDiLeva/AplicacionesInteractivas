package com.dto;
import java.io.Serializable;

import com.model.Edificio;
import com.model.Unidad;

public class UnidadDTO implements Serializable {
    private Long id;
    private int piso;
    private int nro;
    private boolean habitado;
    private Long edificioId;
    //private String inquilinos;
    //private String duenios;

    public UnidadDTO(){

    }
    public UnidadDTO(Long id, int piso, int nro, boolean habitado, Long edificioId){
        this.id=id;
        this.piso=piso;
        this.nro=nro;
        this.habitado=habitado;
        this.edificioId=edificioId;
    }
    public Unidad newUnidad(Edificio edificio) {
        return new Unidad( this.id , this.piso,this.nro,this.habitado,edificio);
    }

    public UnidadDTO update(Unidad unidad){
        Long edificioId = ( this.edificioId == null )? unidad.getEdificio().getId() : this.edificioId;
        return new UnidadDTO(unidad.getId(),unidad.getPiso(),unidad.getNro(),unidad.getHabitado(),edificioId );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public boolean getHabitado() {
        return habitado;
    }

    public void setHabitado(boolean h) {
        this.habitado = h;
    }

    public Long getEdificio(){
        return this.edificioId;
    }
    public void setEdificio(Long edificio){
        this.edificioId=edificio;
    }
    /*public String getInquilinos(){
        return this.inquilinos;
    }
    public void setInquilinos(String inquilinos){
        this.inquilinos=inquilinos;
    }
    public String getDuenios(){
        return this.inquilinos;
    }
    public void setDuenios(String duenios){
        this.duenios=duenios;
    }*/
}
