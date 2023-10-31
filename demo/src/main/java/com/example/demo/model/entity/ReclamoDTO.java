package com.example.demo.model.entity;

public class ReclamoDTO {
    private Unidad unidad;
    private String descripcion;
    private Foto foto;
    private EstadoReclamo estado;
    private Usuario usuario;

    public ReclamoDTO(Unidad unidad, String descripcion, Foto foto, EstadoReclamo estado, Usuario usuario) {
        this.unidad = unidad;
        this.descripcion = descripcion;
        this.foto = foto;
        this.estado = estado;
        this.usuario = usuario;
    }

    public ReclamoDTO() {

    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public EstadoReclamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoReclamo estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
