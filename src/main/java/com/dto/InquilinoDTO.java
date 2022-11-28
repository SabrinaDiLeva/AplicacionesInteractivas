package com.dto;

import java.io.Serializable;

import com.model.Inquilino;
import com.model.Persona;

public class InquilinoDTO implements Serializable {
    private Long id;
    private Long personaId;
    
    public InquilinoDTO(){

    }
    public InquilinoDTO(Long id, Long persona){
        this.id = id;
        this.personaId=persona;
    }

    public Inquilino newInquilino(Persona persona) {
        return new Inquilino( this.id , persona);
    }

    public InquilinoDTO update(Inquilino inquilino){
        Long personaId = ( this.personaId == null )? inquilino.getPersona().getId() : this.personaId;
        return new InquilinoDTO(inquilino.getId(), personaId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getPersona() {
        return personaId;
    }

    public void setPersona(Long id) {
        this.personaId = id;
    }
}
