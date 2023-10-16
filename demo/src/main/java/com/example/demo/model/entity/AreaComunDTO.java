package com.example.demo.model.entity;

import java.util.List;

public class AreaComunDTO {

    private String nombre;

    private String descripcion;

    private Edificio edificio;

    private List<Reclamo> reclamos;


    public AreaComunDTO() {
    }

    /**
     * AreaComunDTO Constructor
     * @param nombre
     * @param descripcion
     * @param edificio
     * @param reclamos
     */

    public AreaComunDTO(String nombre, String descripcion, Edificio edificio, List<Reclamo> reclamos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edificio = edificio;
        this.reclamos = reclamos;
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

    public List<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }
}
