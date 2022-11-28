package com.repository;
import com.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface IReclamoRepository extends JpaRepository<Reclamo,Long>{
    List<Reclamo> findAllByUnidad_Id(Long id);
    List<Reclamo> findAllByPersona_Id(Long id);
}
