package com.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="reclamo")
public class Reclamo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ubicacion;

    @Column 
    private String descripcion;

    @Column
    private String estado;

    //unidad
    @ManyToOne
    @JoinColumn(name = "unidad_id",referencedColumnName = "id")
    private Unidad unidad;

    //persona
    @ManyToOne
    @JoinColumn(name = "persona_id",referencedColumnName = "id")
    private Persona persona;

    @OneToMany(mappedBy = "reclamo")
    @JsonIgnore
    private Set<Imagen> imagenes = new HashSet<>();
    public Reclamo(){

    }
    public Reclamo(Long id, String ubicacion, String descripcion, String estado, Persona persona, Unidad unidad){
        this.id=id;
        this.ubicacion=ubicacion;
        this.descripcion=descripcion;
        this.estado=estado;
        this.persona=persona;
        this.unidad=unidad;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String u) {
        this.ubicacion = u;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String d) {
        this.descripcion = d;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String u) {
        this.estado = u;
    }
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona p) {
        this.persona=p;
    }
    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad u) {
        this.unidad=u;
    }
}
