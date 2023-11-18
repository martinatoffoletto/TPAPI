package com.example.demo.model.entity;

import java.util.Arrays;

import jakarta.persistence.*;

@Embeddable
public class Foto {
    private Long id_foto;

    @Lob
    @Column(
            columnDefinition = "LONGBLOB"
    )
    private byte[] datosImagen;


    public Foto() {
        // TODO Auto-generated constructor stub
    }

    public Foto(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public byte[] getDatosImagen() {
        return this.datosImagen;
    }

    public void setDatosImagen(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public String toString() {
        return "Imagen [datosImagen=" + Arrays.toString(this.datosImagen) + "]";
    }
}