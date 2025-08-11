package com.example.API1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API1.models.EducacionModel;
import com.example.API1.repositories.EducacionRepository;

@Service
public class EducacionService {
    
    @Autowired
    private EducacionRepository educacionRepository;

    public ArrayList<EducacionModel> obtenerEducaciones() {
        return (ArrayList<EducacionModel>) educacionRepository.findAll();
    }

    public EducacionModel guardarEducacion(EducacionModel educacion) {
        return educacionRepository.save(educacion);
    }

    public Optional<EducacionModel> obtenerPorId(Long id) {
        return educacionRepository.findById(id);
    }

    public EducacionModel actualizarEducacion(Long id, EducacionModel educacionActualizada) {
        Optional<EducacionModel> educacionExistente = educacionRepository.findById(id);
        
        if (educacionExistente.isPresent()) {
            EducacionModel educacion = educacionExistente.get();
            educacion.setNivelModalidad(educacionActualizada.getNivelModalidad());
            educacion.setPrivado(educacionActualizada.getPrivado());
            educacion.setEstatal(educacionActualizada.getEstatal());
            educacion.setTipo(educacionActualizada.getTipo());
            educacion.setSort(educacionActualizada.getSort());
            return educacionRepository.save(educacion);
        }
        return null;
    }

    public boolean eliminarEducacion(Long id) {
        try {
            educacionRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<EducacionModel> obtenerPorNivelModalidad(String nivelModalidad) {
        return educacionRepository.findByNivelModalidad(nivelModalidad);
    }

    public ArrayList<EducacionModel> obtenerPorTipo(String tipo) {
        return educacionRepository.findByTipo(tipo);
    }

    public ArrayList<EducacionModel> obtenerPorTipoYNivel(String tipo, String nivelModalidad) {
        return educacionRepository.findByTipoAndNivelModalidad(tipo, nivelModalidad);
    }

    public List<EducacionModel> obtenerPorRangoPrivado(Integer min, Integer max) {
        return educacionRepository.findByPrivadoBetween(min, max);
    }

    public List<EducacionModel> obtenerPorRangoEstatal(Integer min, Integer max) {
        return educacionRepository.findByEstatalBetween(min, max);
    }
}
