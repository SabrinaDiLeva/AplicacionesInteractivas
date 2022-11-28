package com.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="unidad")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int piso;

    @Column
    private int nro;

    @Column
    private boolean habitado;

    //relacion a edificio
    @ManyToOne
    @JoinColumn(name = "edificio_id",referencedColumnName = "id")
    private Edificio edificio;

    @ManyToMany
    @JoinTable(
            name = "unidad_has_duenio",
            joinColumns = @JoinColumn(name = "unidad_id"),
            inverseJoinColumns = @JoinColumn(name = "duenio_id")
    )
    private Set<Duenio> duenio = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "unidad_has_inquilino",
            joinColumns = @JoinColumn(name = "unidad_id"),
            inverseJoinColumns = @JoinColumn(name = "inquilino_id")
    )
    private Set<Inquilino> inquilino = new HashSet<>();

    @OneToMany(mappedBy = "unidad")
    @JsonIgnore
    private Set<Reclamo> reclamos = new HashSet<>();

    public Unidad(){

    }
    public Unidad(Long id, int piso, int nro, boolean habitado, Edificio edificio){
        this.id=id;
        this.piso=piso;
        this.nro=nro;
        this.habitado=habitado;
        this.edificio=edificio;
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

    public Edificio getEdificio(){
        return this.edificio;
    }
    public void setEdificio(Edificio edificio){
        this.edificio=edificio;
    }
    public Set<Duenio> getDuenio() {
        return duenio;
    }
    public void setDuenio(Set<Duenio> duenio) {
        this.duenio = duenio;
    }
    public Set<Inquilino> getInquilino() {
        return inquilino;
    }
    public void setInquilino(Set<Inquilino> inquilino) {
        this.inquilino = inquilino;
    }

    public Set<Reclamo> getReclamo() {
        return reclamos;
    }
    public void setReclamo(Set<Reclamo> reclamo) {
        this.reclamos = reclamo;
    }
}
