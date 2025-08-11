package com.example.API1.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "educacion")
public class EducacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nivel_modalidad")
    private String nivelModalidad;
    
    @Column(name = "privado")
    private Integer privado;
    
    @Column(name = "estatal")
    private Integer estatal;
    
    @Column(name = "tipo")
    private String tipo;
    
    @ElementCollection
    @CollectionTable(name = "educacion_sort", joinColumns = @JoinColumn(name = "educacion_id"))
    @Column(name = "sort_value")
    private List<String> sort;

    public EducacionModel() {}

    
    public EducacionModel(String nivelModalidad, Integer privado, Integer estatal, String tipo, List<String> sort) {
        this.nivelModalidad = nivelModalidad;
        this.privado = privado;
        this.estatal = estatal;
        this.tipo = tipo;
        this.sort = sort;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getNivelModalidad() {
        return nivelModalidad;
    }
    public void setNivelModalidad(String nivelModalidad) {
        this.nivelModalidad = nivelModalidad;
    }
    public Integer getPrivado() {
        return privado;
    }
    public void setPrivado(Integer privado) {
        this.privado = privado;
    }
    public Integer getEstatal() {
        return estatal;
    }
    public void setEstatal(Integer estatal) {
        this.estatal = estatal;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public List<String> getSort() {
        return sort;
    }
    public void setSort(List<String> sort) {
        this.sort = sort;
    }
}
