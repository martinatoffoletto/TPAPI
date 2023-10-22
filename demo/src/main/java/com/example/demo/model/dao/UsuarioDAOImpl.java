package com.example.demo.model.dao;

import com.example.demo.model.entity.Unidad;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.demo.model.entity.Usuario;

import java.util.Collections;
import java.util.List;

@Repository
public class UsuarioDAOImpl implements daos{

    @PersistenceContext
    private EntityManager entityManager;


    /*
    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarUsuario(String username, String password) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("FROM Usuario WHERE nombreUsuario=:username", Usuario.class);
        theQuery.setParameter("username", username);

        Usuario user = theQuery.uniqueResult();

        if(user != null && checkPassword(password, user.getContrasenia())){
            return user;
        }else {
            return null;
        }
    }

    private boolean checkPassword(String password, String passwordDB){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String hashedPassword = passwordEncoder.encode(password);
        System.out.println("Password: " + password);
        //System.out.println("hashedPassword: " + hashedPassword);
        System.out.println("passwordDB" + passwordDB);
        boolean isPasswordMatch = passwordEncoder.matches(password, passwordDB);

        return isPasswordMatch;
    }

     */


    @Override
    @Transactional(readOnly = true)
    public List<Object> gelAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> getQuery = currentSession.createQuery("from Usuario", Usuario.class);
        List<Usuario> Usuarios = getQuery.getResultList();
        List<Object> unidad= Collections.singletonList(Usuarios);
        return unidad;
    }

    @Override
    @Transactional(readOnly = true)
    public Object findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Usuario unidad = currentSession.get(Usuario.class, id);
        return unidad;
    }


    @Override
    @Transactional
    public void save(Object obj) {
        Session currentSession = entityManager.unwrap(Session.class);
        Usuario unidad=(Usuario) obj;
        currentSession.persist(unidad);

    }

    @Override
    @Transactional
    public void update(Object obj) {
        Session session = entityManager.unwrap(Session.class);
        Usuario unidad= (Usuario) obj;
        session.update(unidad);

    }

    @Override
    @Transactional
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Unidad> theQuery = currentSession.createQuery("delete from Usuario where id=:id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();

    }
}
