package com.example.demo.model.dao;

import com.example.demo.model.entity.*;
import com.example.demo.service.EdificioServiceImpl;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import com.example.demo.model.entity.Reclamo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class ReclamoDAOImpl implements daos{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Object> gelAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Reclamo> getQuery = currentSession.createQuery("from Reclamo", Reclamo.class);
        List<Reclamo> reclamos = getQuery.getResultList();
        List<Object> reclamo= Collections.singletonList(reclamos);
        return reclamo;
    }

    @Override
    @Transactional(readOnly = true)
    public Object findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Reclamo reclamo = currentSession.get(Reclamo.class, id);
        return reclamo;
    }


    @Override
    @Transactional
    public void save(Object obj) {
        Session currentSession = entityManager.unwrap(Session.class);
        Reclamo reclamo= (Reclamo) obj;
        currentSession.persist(reclamo);
    }

    @Override
    @Transactional
    public void update(Object obj) {
        Session session = entityManager.unwrap(Session.class);
        Reclamo unidad= (Reclamo) obj;
        session.update(unidad);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Reclamo> theQuery = currentSession.createQuery("delete from Reclamo where numero=:numeroR");

        theQuery.setParameter("numeroR", id);
        theQuery.executeUpdate();

    }


    @Transactional
    public List<Reclamo> findByEdificio(Long idEdificio){
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("FROM Reclamo WHERE areaComun.edificio.id=:idEdificio OR unidad.edificio.id=:idEdificio");
        theQuery.setParameter("idEdificio", idEdificio);
        List<?> resultList = theQuery.getResultList();

        List<Reclamo> reclamosList = new ArrayList<>();
        for (Object obj : resultList) {
            if (obj instanceof Reclamo) {
                reclamosList.add((Reclamo) obj);
            }
        }

        return reclamosList;
    }

    @Transactional
    public List<Reclamo> findByUsuario(String nombreUsuario){
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("FROM Reclamo WHERE usuario.nombreUsuario=:nombreUsuario");
        theQuery.setParameter("nombreUsuario", nombreUsuario);
        List<?> resultList = theQuery.getResultList();

        List<Reclamo> reclamoList = new ArrayList<>();
        for (Object obj : resultList){
            if (obj instanceof Reclamo) {
                reclamoList.add((Reclamo) obj);
            }
        }

        return reclamoList;
    }




}
