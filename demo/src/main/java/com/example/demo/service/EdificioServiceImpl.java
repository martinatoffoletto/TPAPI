package com.example.demo.service;

import com.example.demo.model.dao.EdificioDAOImpl;
import com.example.demo.model.dao.daos;
import com.example.demo.model.entity.Edificio;

import java.util.Collections;
import java.util.List;

public class EdificioServiceImpl implements IEdificioService{

    private EdificioDAOImpl edificioDAO;

    @Override
    public List<Edificio> findAll() {
        List<Edificio> edificios = Collections.singletonList((Edificio) edificioDAO.gelAll());
        return edificios;
    }

    @Override
    public Edificio findById(Long id) {
        Edificio edificio = (Edificio) edificioDAO.findById(id);
        return edificio;
    }


    @Override
    public void save(Edificio edificio) {
        edificioDAO.save(edificio);
    }

    @Override
    public void update(Long edificioId, Edificio edificio) {
        Edificio edificioExistente = (Edificio) edificioDAO.findById(edificioId);

        if (edificioExistente != null){
            edificioExistente.setDireccion(edificio.getDireccion());
            edificioExistente.setAreasComunes(edificio.getAreasComunes());
            edificioExistente.setUnidades(edificio.getUnidades());

            edificioDAO.save(edificioExistente);
        }

    }

    @Override
    public void deleteById(Long id) {
        edificioDAO.delete(id);
    }

}
