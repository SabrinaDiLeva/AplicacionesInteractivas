package com.dto;
import java.io.Serializable;
import com.model.Edificio;

public class EdificioDTO implements Serializable {
    public static final int NOMBRE_MAX_LENGTH = 100;
    public static final int DIRECCION_MAX_LENGTH = 300;
    private Long id;
    private String nombre;
    private String direccion;

    public EdificioDTO(){

    }
    public EdificioDTO(Long id, String nombre, String direccion){
        this.id=id;
        this.nombre=nombre;
        this.direccion=direccion;
    }

    public Edificio newEdificio() {
        return new Edificio( this.id , this.nombre, this.direccion);
    }

    public EdificioDTO update(Edificio edificio){
        if (this.nombre!= null && nombre.length() <= NOMBRE_MAX_LENGTH)
            edificio.setNombre(this.nombre);
        if (this.direccion != null && direccion.length() <= DIRECCION_MAX_LENGTH)
            edificio.setDireccion(this.direccion);
        return new EdificioDTO(edificio.getId(), edificio.getNombre(), edificio.getDireccion());
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
}
