package com.example.demo.model.dao;

import com.example.demo.model.entity.Usuario;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entity.AreaComun;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collections;
import java.util.List;

@Repository
public class AreaComunDAOImpl implements daos{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Object> gelAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query getQuery = currentSession.createQuery("from AreaComun", AreaComun.class);
        List<AreaComun> areasComunes = getQuery.getResultList();
        List<Object> areaComun= Collections.singletonList(areasComunes);
        return areaComun;
    }

    @Override
    @Transactional(readOnly = true)
    public AreaComun findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        AreaComun areaComun = currentSession.get(AreaComun.class, id);

        return areaComun;
    }

    @Override
    @Transactional
    public void save(Object obj) {
        Session currentSession = entityManager.unwrap(Session.class);
        AreaComun areaComun= (AreaComun) obj;
        currentSession.persist(areaComun);
    }


    @Override
    @Transactional
    public void update(Object obj) {
        Session session = entityManager.unwrap(Session.class);
        AreaComun unidad= (AreaComun) obj;
        session.update(unidad);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from AreaComun where id=:idAreaComun");
        theQuery.setParameter("idAreaComun", id);
        theQuery.executeUpdate();

    }





}
