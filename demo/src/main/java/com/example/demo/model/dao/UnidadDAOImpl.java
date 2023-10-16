package com.example.demo.model.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entity.Reclamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.demo.model.entity.Unidad;

import java.util.List;

@Repository
public class UnidadDAOImpl implements IUnidadDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Unidad> findAllUnidades() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Unidad> getQuery = currentSession.createQuery("from Unidad", Unidad.class);
        List<Unidad> unidades = getQuery.getResultList();

        return unidades;
    }

    @Override
    @Transactional(readOnly = true)
    public Unidad findUnidadById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Unidad unidad = currentSession.get(Unidad.class, id);
        return unidad;
    }

    @Override
    @Transactional
    public void save(Unidad unidad) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(unidad);

    }

    @Override
    @Transactional
    public void deleteUnidadById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Unidad> theQuery = currentSession.createQuery("delete from Unidad where id=:id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();

    }
}
