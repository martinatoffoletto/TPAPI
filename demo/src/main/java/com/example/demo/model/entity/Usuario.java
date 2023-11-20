package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import static com.example.demo.model.entity.TipoUsuario.ADMINISTRADOR;

@Entity
@Table(name = "usuarios_tabla", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre_usuario"})})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKeyJoinColumn(name = "id_usuario")
    @Column(name="id_usuario", nullable=false)
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    @Column(name="nombre_usuario", nullable = false)
    private String nombreUsuario;
    private String contrasenia;
    private TipoUsuario tipoUsuario;
    private boolean aceptado;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Usuario> ingresosPendientes;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, int dni, String nombreUsuario, String contrasenia, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;


        if(this.tipoUsuario==ADMINISTRADOR){
            this.ingresosPendientes = new ArrayList<Usuario>();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }


    public List<Usuario> getIngresosPendientes() {
        return ingresosPendientes;
    }

    public void setIngresosPendientes(List<Usuario> ingresosPendientes) {
        this.ingresosPendientes = ingresosPendientes;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
