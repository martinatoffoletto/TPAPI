package com.example.demo.service;

import com.example.demo.model.dao.AreaComunDAOImpl;
import com.example.demo.model.entity.AreaComun;
import com.example.demo.model.entity.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AreaComunServiceImpl implements IAreaComunService{

    @Autowired
    private AreaComunDAOImpl areaComunDAO;

    @Override
    public List<AreaComun> findAll() {
        return Collections.singletonList((AreaComun) areaComunDAO.gelAll());
    }

    @Override
    public AreaComun findById(Long id) {
        return (AreaComun) areaComunDAO.findById(id);
    }

    @Override
    public void save(AreaComun areaComun) {
        areaComunDAO.save(areaComun);
    }

    @Override
    public void update(Long areaComunId, AreaComun areaComun) {
        AreaComun areaComun1 = (AreaComun) areaComunDAO.findById(areaComunId);

        if (areaComun1 != null){
            areaComun1.setNombre(areaComun.getNombre());
            areaComun1.setEdificio(areaComun.getEdificio());
            areaComun1.setDescripcion(areaComun.getDescripcion());

            areaComunDAO.save(areaComun1);
        }
    }

    @Override
    public void deleteById(Long id) {
        areaComunDAO.delete(id);
    }

    @Override
    public List<AreaComun> findPorEdificio(Long idEdificio) {
        return areaComunDAO.findByEdificio(idEdificio);
    }
}
