package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "edificios_tabla")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name="id", nullable=false)
    private Long id;
    private String direccion;
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Unidad> unidades;
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<AreaComun> areasComunes;

    public Edificio(String direccion) {
        this.direccion = direccion;
    }

    public Edificio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
    }

    public List<AreaComun> getAreasComunes() {
        return areasComunes;
    }

    public void setAreasComunes(List<AreaComun> areasComunes) {
        this.areasComunes = areasComunes;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", unidades=" + unidades +
                ", areasComunes=" + areasComunes +
                '}';
    }

}
