package com.example.demo.model.entity;

public class AreaComunDTO {

    private String nombre;
    private String descripcion;
    private Edificio edificio;

    public AreaComunDTO(String nombre, String descripcion, Edificio edificio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edificio = edificio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
}
