package com.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="inquilino")
public class Inquilino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")

    private Persona persona;
    @ManyToMany(mappedBy = "inquilino")
    private Set<Unidad> unidad = new HashSet<>();

    public Inquilino(){

    }
    public Inquilino(Long id, Persona persona){
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
}