package com.example.demo.model.entity;

public class EdificioDTO {

    private String direccion;

    public EdificioDTO(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
