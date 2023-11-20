package com.example.demo.model.entity;

public class UnidadDTO {
    private int piso;
    private int numeroUnidad;
    private boolean habitada;
    private boolean alquilada;
    private Edificio edificio;
    private Usuario usuario;

    public UnidadDTO(int piso, int numeroUnidad, boolean habitada, boolean alquilada, Edificio edificio, Usuario usuario) {
        this.piso = piso;
        this.numeroUnidad = numeroUnidad;
        this.habitada = habitada;
        this.alquilada = alquilada;
        this.edificio = edificio;
        this.usuario = usuario;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumeroUnidad() {
        return numeroUnidad;
    }

    public void setNumeroUnidad(int numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    public boolean isHabitada() {
        return habitada;
    }

    public void setHabitada(boolean habitada) {
        this.habitada = habitada;
    }

    public boolean isAlquilada() {
        return alquilada;
    }

    public void setAlquilada(boolean alquilada) {
        this.alquilada = alquilada;
    }

    public String  getEdificio() {
        return edificio.toString();
    }

    public Edificio getEdificio1(){ return edificio;}

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public String getUsuario() {
        return usuario.toString();
    }
    public Usuario getUsuario1(){return usuario;}

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
