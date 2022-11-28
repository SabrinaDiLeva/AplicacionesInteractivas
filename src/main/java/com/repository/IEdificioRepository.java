package com.repository;
import com.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IEdificioRepository extends JpaRepository<Edificio,Long>{
    
}
