package com.example.demo.model.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entity.Reclamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import com.example.demo.model.entity.Reclamo;

import java.util.List;

@Repository
public class ReclamoDAOImpl implements IReclamoDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Reclamo> findAllReclamos() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Reclamo> getQuery = currentSession.createQuery("from Reclamo", Reclamo.class);
        List<Reclamo> reclamos = getQuery.getResultList();

        return reclamos;

    }

    @Override
    @Transactional(readOnly = true)
    public Reclamo findByNumero(Long numeroR) {
        Session currentSession = entityManager.unwrap(Session.class);
        Reclamo reclamo = currentSession.get(Reclamo.class, numeroR);
        return reclamo;
    }

    @Override
    @Transactional
    public void save(Reclamo reclamo) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(reclamo);

    }

    @Override
    @Transactional
    public void deleteByNumero(Long numeroR) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Reclamo> theQuery = currentSession.createQuery("delete from Reclamo where numero=:numeroR");
        theQuery.setParameter("numeroR", numeroR);
        theQuery.executeUpdate();

    }
}
