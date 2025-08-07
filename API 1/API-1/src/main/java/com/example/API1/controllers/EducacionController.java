package com.example.API1.controllers;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API1.models.EducacionModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class EducacionController {
    @GetMapping("/educacion")
    public List<EducacionModel> getEducacion() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/educacion.json");
            
            if (is == null) {
                // Si no encuentra el archivo, devuelve datos de prueba
                EducacionModel educacion = new EducacionModel();
                educacion.setSort(Arrays.asList("Archivo no encontrado", "Usando datos de prueba"));
                return Arrays.asList(educacion);
            }
            
            return mapper.readValue(is, new TypeReference<List<EducacionModel>>() {});
            
        } catch (Exception e) {
            // Si hay error, devuelve datos de prueba con el error
            EducacionModel educacion = new EducacionModel();
            educacion.setSort(Arrays.asList("Error:", e.getMessage()));
            return Arrays.asList(educacion);
        }
    }
}
