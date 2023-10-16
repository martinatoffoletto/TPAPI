package com.example.demo.model.dao;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entity.AreaComun;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
public class AreaComunDAOImpl implements IAreaComunDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public List<AreaComun> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query getQuery = currentSession.createQuery("from AreaComun", AreaComun.class);
        List<AreaComun> areasComunes = getQuery.getResultList();

        return areasComunes;
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
    public void save(AreaComun areaComun) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(areaComun);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from AreaComun where id=:idAreaComun");
        theQuery.setParameter("idAreaComun", id);
        theQuery.executeUpdate();

    }
}
