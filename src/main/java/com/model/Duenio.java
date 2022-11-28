package com.model;
import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name="duenio")
public class Duenio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

    @ManyToMany(mappedBy = "duenio")
    private Set<Unidad> unidad = new HashSet<>();

    public Duenio(){

    }
    public Duenio(Long id, Persona persona){
        this.id=id;
        this.persona=persona;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona id) {
        this.persona = id;
    }

    public Set<Unidad> getUnidades() {
        return unidad;
    }

    public void setUnidades(Set<Unidad> unidad) {
        this.unidad = unidad;
    }
}
