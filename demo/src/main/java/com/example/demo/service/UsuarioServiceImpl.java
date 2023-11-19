package com.example.demo.service;

import com.example.demo.model.dao.EdificioDAOImpl;
import com.example.demo.model.dao.UsuarioDAOImpl;
import com.example.demo.model.entity.Edificio;
import com.example.demo.model.entity.Usuario;

import java.util.Collections;
import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService{
    private UsuarioDAOImpl usuarioDAO;
    public List<Usuario> findAll(){
        List<Usuario> usuarios = Collections.singletonList((Usuario) usuarioDAO.gelAll());
        return usuarios;
    }

    public Usuario findById(Long id){
        Usuario usuario = (Usuario) usuarioDAO.findById(id);
        return usuario;
    }


    public Usuario findByUsuario(String nombreUser, String contra) {
        return usuarioDAO.encontrarUsuario(nombreUser, contra);
    }

    public void save(Usuario usuario){
        usuarioDAO.save(usuario);
    }

    public void update(Long usuarioId, Usuario usuario){
        Usuario usuarioExistente = (Usuario) usuarioDAO.findById(usuarioId);

        if (usuarioExistente != null){
            usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
            usuarioExistente.setContrasenia(usuario.getContrasenia());
            usuarioExistente.setTipoUsuario(usuario.getTipoUsuario());

            usuarioDAO.save(usuarioExistente);
        }
    }

    public void deleteById(Long id){
        usuarioDAO.delete(id);
    }
}
