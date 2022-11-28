package com.repository;
import com.model.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IInquilinoRepository extends JpaRepository<Inquilino,Long>{
    
}
