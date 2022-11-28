package com.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="imagen")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String url;

    @Column
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "reclamo_id",referencedColumnName = "id")
    private Reclamo reclamo;

    public Imagen(){

    }
    public Imagen(Long id, String url, String tipo, Reclamo reclamo){
        this.id=id;
        this.url=url;
        this.tipo=tipo;
        this.reclamo=reclamo;
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
    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo p) {
        this.reclamo = p;
    }
}
