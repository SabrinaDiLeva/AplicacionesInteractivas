package com.repository;
import com.model.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IUnidadRepository extends JpaRepository<Unidad,Long>{
    List<Unidad> findAllByEdificio_Id(Long id);
}
