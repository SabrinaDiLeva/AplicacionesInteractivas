package com.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String documento;

    @Column
    private String nombre;

    @OneToOne(mappedBy="persona")
    private Duenio duenio;

    @OneToOne(mappedBy="persona")
    private Inquilino inquilino;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private Set<Reclamo> reclamos = new HashSet<>();

    public Persona() {
    }

    public Persona(Long id, String documento, String nombre) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setTitulo(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
