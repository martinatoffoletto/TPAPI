package com.example.demo.model.dao;

import com.example.demo.model.entity.AreaComun;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.demo.model.entity.Edificio;

import java.util.List;

@Repository
public class EdificioDAOImpl implements IEdificioDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public Edificio findEdificio(String direccion) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Edificio> theQuery = currentSession.createQuery("FROM Edificio WHERE direccion=:direccion", Edificio.class);
        theQuery.setParameter("direccion", direccion);

        Edificio edificio = theQuery.uniqueResult();

        return edificio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Edificio> findAllEdificios() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Edificio> getQuery = currentSession.createQuery("from Edificio", Edificio.class);
        List<Edificio> edificios = getQuery.getResultList();

        return edificios;
    }

    @Override
    @Transactional
    public void save(Edificio edificio) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(edificio);
    }

    @Override
    @Transactional
    public void deleteEdificioById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Edificio> theQuery = currentSession.createQuery("delete from Edificio where id=:idEdificio");
        theQuery.setParameter("idEdificio", id);
        theQuery.executeUpdate();
    }
}
