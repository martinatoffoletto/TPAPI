package com.example.demo.model.dao;

import com.example.demo.model.entity.Usuario;

public interface IUsuarioDAO {
    public Usuario encontrarUsuario(String username, String password);

}
