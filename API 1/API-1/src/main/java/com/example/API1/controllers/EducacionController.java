package com.example.API1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.API1.models.EducacionModel;
import com.example.API1.services.EducacionService;

@RestController
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    // GET - Obtener todas las educaciones
    @GetMapping()
    public ArrayList<EducacionModel> obtenerEducaciones() {
        return educacionService.obtenerEducaciones();
    }

    // POST - Crear nueva educación
    @PostMapping()
    public EducacionModel guardarEducacion(@RequestBody EducacionModel educacion) {
        return educacionService.guardarEducacion(educacion);
    }

    // GET - Obtener educación por ID
    @GetMapping("/{id}")
    public ResponseEntity<EducacionModel> obtenerEducacionPorId(@PathVariable("id") Long id) {
        Optional<EducacionModel> educacion = educacionService.obtenerPorId(id);
        if (educacion.isPresent()) {
            return ResponseEntity.ok(educacion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT - Actualizar educación existente
    @PutMapping("/{id}")
    public ResponseEntity<EducacionModel> actualizarEducacion(
            @PathVariable("id") Long id, 
            @RequestBody EducacionModel educacion) {
        EducacionModel educacionActualizada = educacionService.actualizarEducacion(id, educacion);
        if (educacionActualizada != null) {
            return ResponseEntity.ok(educacionActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Eliminar educación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEducacion(@PathVariable("id") Long id) {
        boolean eliminado = educacionService.eliminarEducacion(id);
        if (eliminado) {
            return ResponseEntity.ok("Educación eliminada exitosamente con ID: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET - Buscar por nivel modalidad
    @GetMapping("/nivel/{nivelModalidad}")
    public ArrayList<EducacionModel> obtenerPorNivelModalidad(@PathVariable("nivelModalidad") String nivelModalidad) {
        return educacionService.obtenerPorNivelModalidad(nivelModalidad.replace("_", " "));
    }

    // GET - Buscar por tipo (Matricula o UE)
    @GetMapping("/tipo/{tipo}")
    public ArrayList<EducacionModel> obtenerPorTipo(@PathVariable("tipo") String tipo) {
        return educacionService.obtenerPorTipo(tipo);
    }

    // GET - Buscar por tipo y nivel modalidad
    @GetMapping("/filtro")
    public ArrayList<EducacionModel> obtenerPorTipoYNivel(
            @RequestParam("tipo") String tipo,
            @RequestParam("nivel") String nivelModalidad) {
        return educacionService.obtenerPorTipoYNivel(tipo, nivelModalidad);
    }

    // GET - Buscar por rango de matrícula privada
    @GetMapping("/privado/rango")
    public List<EducacionModel> obtenerPorRangoPrivado(
            @RequestParam("min") Integer min,
            @RequestParam("max") Integer max) {
        return educacionService.obtenerPorRangoPrivado(min, max);
    }

    // GET - Buscar por rango de matrícula estatal
    @GetMapping("/estatal/rango")
    public List<EducacionModel> obtenerPorRangoEstatal(
            @RequestParam("min") Integer min,
            @RequestParam("max") Integer max) {
        return educacionService.obtenerPorRangoEstatal(min, max);
    }
}
