package com.example.API1.models;

import java.util.List;

public class EducacionModel {
    private String nivel_modalidad;
    private int privado;
    private int estatal;
    private String tipo;
    private List<String> sort;

    // Getters y setters
    public String getNivel_modalidad() {
        return nivel_modalidad;
    }
    public void setNivel_modalidad(String nivel_modalidad) {
        this.nivel_modalidad = nivel_modalidad;
    }
    public int getPrivado() {
        return privado;
    }
    public void setPrivado(int privado) {
        this.privado = privado;
    }
    public int getEstatal() {
        return estatal;
    }
    public void setEstatal(int estatal) {
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
