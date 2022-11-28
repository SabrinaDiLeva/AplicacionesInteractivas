package com.repository;
import com.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
}
