package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "reclamos_tabla")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKeyJoinColumn
    @Column(name="numero", nullable=false)
    private Long numero;

    @ManyToOne
    @JoinColumn(name = "id_unidad", referencedColumnName = "id")
    private Unidad unidad;
    @ManyToOne
    @JoinColumn(name = "id_area_comun", referencedColumnName = "id")
    private AreaComun areaComun;
    private String descripcion;
    @Embedded
    private Foto foto;
    private EstadoReclamo estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String medidasTomadas;

    public Reclamo() {
    }

    public Reclamo(Unidad unidad, String descripcion, Foto foto, EstadoReclamo estado, Usuario usuario) {
        this.unidad = unidad;
        this.descripcion = descripcion;
        this.foto = foto;
        this.estado = estado;
        this.usuario = usuario;
        this.medidasTomadas = "Creación de Reclamo";
    }

    public Reclamo(AreaComun areaComun, String descripcion, Foto foto, EstadoReclamo estado, Usuario usuario) {
        this.areaComun = areaComun;
        this.descripcion = descripcion;
        this.foto = foto;
        this.estado = estado;
        this.usuario = usuario;
        this.medidasTomadas = "Creación de Reclamo";
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public AreaComun getAreaComun() {
        return areaComun;
    }

    public void setAreaComun(AreaComun areaComun) {
        this.areaComun = areaComun;
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

    @Override
    public String toString() {
        return "Reclamo{" +
                "numero=" + numero +
                ", unidad=" + unidad +
                ", areaComun=" + areaComun +
                ", descripcion='" + descripcion + '\'' +
                ", foto=" + foto +
                ", estado=" + estado +
                ", usuario=" + usuario +
                '}';
    }
}
