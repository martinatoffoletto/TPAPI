package com.example.demo.model.dao;

import com.example.demo.model.entity.AreaComun;
import com.example.demo.model.entity.Usuario;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.demo.model.entity.Edificio;

import java.util.Collections;
import java.util.List;

@Repository
public class EdificioDAOImpl implements daos{

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    @Transactional(readOnly = true)
    public List<Object> gelAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Edificio> getQuery = currentSession.createQuery("from Edificio", Edificio.class);
        List<Edificio> edificios = getQuery.getResultList();
        List<Object> edificio= Collections.singletonList(edificios);
        return edificio;
    }

    @Override
    @Transactional(readOnly = true)
    public Object findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Edificio> theQuery = currentSession.createQuery("FROM Edificio WHERE id=:id", Edificio.class);
        theQuery.setParameter("id", id);

        Edificio edificio = theQuery.uniqueResult();

        return edificio;
    }

    @Override
    @Transactional
    public void save(Object obj) {
        Session currentSession = entityManager.unwrap(Session.class);
        Edificio edificio= (Edificio) obj;
        currentSession.persist(edificio);

    }

    @Override
    @Transactional
    public void update(Object obj) {
        Session session = entityManager.unwrap(Session.class);
        Edificio unidad= (Edificio) obj;
        session.update(unidad);


    }

    @Override
    @Transactional
    public void delete(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Edificio> theQuery = currentSession.createQuery("delete from Edificio where id=:idEdificio");
        theQuery.setParameter("idEdificio", id);
        theQuery.executeUpdate();


    }
}
