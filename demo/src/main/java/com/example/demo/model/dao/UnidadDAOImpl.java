package com.example.demo.model.dao;

import com.example.demo.model.entity.Edificio;
import com.example.demo.model.entity.Unidad;
import com.example.demo.model.entity.Usuario;
import com.example.demo.service.EdificioServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UnidadDAOImpl implements daos{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Object> gelAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Unidad> getQuery = currentSession.createQuery("from Unidad", Unidad.class);
        List<Unidad> unidades = getQuery.getResultList();
        List<Object> unidad= Collections.singletonList(unidades);
        return unidad;
    }


    @Override
    @Transactional(readOnly = true)
    public Object findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Unidad unidad = currentSession.get(Unidad.class, id);
        return unidad;
    }

    @Override
    @Transactional
    public void save(Object obj) {
        Session currentSession = entityManager.unwrap(Session.class);
        Unidad unidad=(Unidad) obj;
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
    public void delete(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Unidad> theQuery = currentSession.createQuery("delete from Unidad where id=:id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();

    }


    @Transactional
    public List<Unidad> findByEdificio(Long idEdificio){
        Session currentSession = entityManager.unwrap(Session.class);

        EdificioServiceImpl edificioService = new EdificioServiceImpl();
        Edificio edificio= edificioService.findById(idEdificio);


        Query theQuery = currentSession.createQuery("FROM Unidad WHERE edificio=:edificio");
        theQuery.setParameter("edificio", edificio);


        List<?> resultList = theQuery.getResultList();

        List<Unidad> unidadList = new ArrayList<>();
        for (Object obj : resultList) {
            if (obj instanceof Unidad) {
                unidadList.add((Unidad) obj);
            }
        }

        return unidadList;
    }


}
