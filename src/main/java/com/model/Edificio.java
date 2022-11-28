package com.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="edificio")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String direccion;

    @OneToMany(mappedBy = "edificio")
    @JsonIgnore
    private Set<Unidad> unidades = new HashSet<>();

    public Edificio(){

    }

    public Edificio(Long id, String nombre, String direccion){
        this.id=id;
        this.nombre=nombre;
        this.direccion=direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion=direccion;
    }
    public Set<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(Set<Unidad> unidades) {
        this.unidades = unidades;
    }
}