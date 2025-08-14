package com.example.API1.models;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "educacion")
public class EducacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nivel_modalidad", nullable = false, length = 100)
    @NotNull(message = "El nivel de modalidad es obligatorio")
    @NotBlank(message = "El nivel de modalidad no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nivel de modalidad debe tener entre 3 y 100 caracteres")
    private String nivelModalidad;
    
    @Column(name = "privado", nullable = false)
    @NotNull(message = "El campo privado es obligatorio")
    @Min(value = 0, message = "El valor privado debe ser mayor o igual a 0")
    private Integer privado;
    
    @Column(name = "estatal", nullable = false)
    @NotNull(message = "El campo estatal es obligatorio")
    @Min(value = 0, message = "El valor estatal debe ser mayor o igual a 0")
    private Integer estatal;
    
    @Column(name = "tipo", nullable = false, length = 50)
    @NotNull(message = "El tipo es obligatorio")
    @NotBlank(message = "El tipo no puede estar vacío")
    @Pattern(regexp = "^(Matricula|UE)$", message = "El tipo debe ser 'Matricula' o 'UE'")
    private String tipo;
    
    @ElementCollection
    @CollectionTable(name = "educacion_sort", joinColumns = @JoinColumn(name = "educacion_id"))
    @Column(name = "sort_value", nullable = false)
    @NotNull(message = "El campo sort es obligatorio")
    @NotEmpty(message = "El array sort no puede estar vacío")
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
