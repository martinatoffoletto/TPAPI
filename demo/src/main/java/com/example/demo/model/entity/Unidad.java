package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "unidades_tabla")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name="id", nullable=false)
    private Long id;
    private int piso;
    private int numeroUnidad;
    private boolean habitada;
    private boolean alquilada;

    @ManyToOne
    @JoinColumn(name = "edificio_id", referencedColumnName = "id")
    private Edificio edificio;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL)
    private List<Reclamo> reclamos;


    public Unidad() {
    }

    public Unidad(int piso, int numeroUnidad, boolean habitada, boolean alquilada, Edificio edificio, Usuario usuario) {
        this.piso = piso;
        this.numeroUnidad = numeroUnidad;
        this.habitada = habitada;
        this.alquilada = alquilada;
        this.edificio = edificio;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "id=" + id +
                ", piso=" + piso +
                ", numeroUnidad=" + numeroUnidad +
                ", habitada=" + habitada +
                ", alquilada=" + alquilada +
                ", edificio=" + edificio +
                ", usuario=" + usuario +
                ", reclamos=" + reclamos +
                '}';
    }
}
