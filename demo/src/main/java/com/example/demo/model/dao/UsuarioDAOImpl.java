package com.example.demo.model.dao;

import com.example.demo.model.entity.Unidad;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Transactional(readOnly = true)
    public Usuario encontrarUsuario(String nombreUsuario, String contrasenia) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario=:nombreUsuario AND u.contrasenia=:contrasenia", Usuario.class);
        theQuery.setParameter("nombreUsuario", nombreUsuario);
        theQuery.setParameter("contrasenia", contrasenia);

        return theQuery.uniqueResult();
    }


    private boolean checkPassword(String password, String passwordDB){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, passwordDB);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Object> gelAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> getQuery = currentSession.createQuery("from Usuario", Usuario.class);
        List<Usuario> usuarios = getQuery.getResultList();
        List<Object> usuario= Collections.singletonList(usuarios);
        return usuario;
    }

    @Override
    @Transactional(readOnly = true)
    public Object findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Usuario usuario = currentSession.get(Usuario.class, id);
        return usuario;
    }


    @Override
    @Transactional
    public void save(Object obj) {
        Session currentSession = entityManager.unwrap(Session.class);
        Usuario usuario=(Usuario) obj;
        currentSession.persist(usuario);

    }

    @Override
    @Transactional
    public void update(Object obj) {
        Session session = entityManager.unwrap(Session.class);
        Usuario usuario= (Usuario) obj;
        session.update(usuario);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Usuario where id=:id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();

    }
}
