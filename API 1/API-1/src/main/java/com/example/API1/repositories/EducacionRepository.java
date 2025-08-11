package com.example.API1.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.API1.models.EducacionModel;

@Repository
public interface EducacionRepository extends CrudRepository<EducacionModel, Long> {
    
    
    public abstract ArrayList<EducacionModel> findByNivelModalidad(String nivelModalidad);
    

    public abstract ArrayList<EducacionModel> findByTipo(String tipo);
    
    
    public abstract ArrayList<EducacionModel> findByTipoAndNivelModalidad(String tipo, String nivelModalidad);
    

    public abstract List<EducacionModel> findByPrivadoBetween(Integer min, Integer max);
    

    public abstract List<EducacionModel> findByEstatalBetween(Integer min, Integer max);
}
