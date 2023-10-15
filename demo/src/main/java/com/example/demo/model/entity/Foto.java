package com.example.demo.model.entity;

import java.util.Arrays;
import jakarta.persistence.*;


@Entity
@Embeddable
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name="id", nullable=false)
    private int numero;

    public Foto() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Lob
    @Column(
            columnDefinition = "LONGBLOB"
    )
    private byte[] datosImagen;


    public Foto(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getDatosImagen() {
        return this.datosImagen;
    }

    public void setDatosImagen(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public String toString() {
        return "Imagen [id=" + this.id + ", datosImagen=" + Arrays.toString(this.datosImagen) + "]";
    }

}
