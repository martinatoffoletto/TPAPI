package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "area_comun_tabla")
public class AreaComun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name="id", nullable=false)
    private Long id;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "edificio_id", referencedColumnName = "id")
    private Edificio edificio;

    @OneToMany(mappedBy = "areaComun", cascade = CascadeType.ALL)
    private List<Reclamo> reclamos;


    public AreaComun(String nombre, String descripcion, Edificio edificio, List<Reclamo> reclamos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edificio = edificio;
        this.reclamos = reclamos;
    }

    public AreaComun() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void getReclamos() {
        for(Reclamo r: reclamos) {
            r.toString();
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //opcion1
    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    //opcion 2 seria ingresar el numero o la direccion del edificio, que verifique la existencia y lo designe
    public void setEdificio(int numEdificio){ }


    public void agregarReclamo(Reclamo reclamo1) {
        this.reclamos.add(reclamo1);
    }

    @Override
    public String toString() {
        return "AreaComun{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", edificio=" + edificio +
                ", reclamos=" + reclamos +
                '}';
    }
}
