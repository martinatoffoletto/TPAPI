package com.example.demo.model.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.demo.model.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements IUsuarioDAO{

    @PersistenceContext
    private EntityManager entityManager;

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
}
