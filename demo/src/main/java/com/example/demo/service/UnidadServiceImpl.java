package com.example.demo.service;

import com.example.demo.model.dao.UnidadDAOImpl;
import com.example.demo.model.entity.AreaComun;
import com.example.demo.model.entity.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UnidadServiceImpl implements IUnidadService{

    @Autowired
    private UnidadDAOImpl unidadDAO;

    @Override
    public List<Unidad> findAll() {
        return Collections.singletonList((Unidad) unidadDAO.gelAll());
    }

    @Override
    public Unidad findById(Long id) {
        return (Unidad) unidadDAO.findById(id);
    }

    @Override
    public void save(Unidad unidad) {
        unidadDAO.save(unidad);
    }

    @Override
    public void update(Long unidadId, Unidad unidad) {
        Unidad unidad1 = (Unidad) unidadDAO.findById(unidadId);

        if (unidad1 != null){
            unidad1.setNumeroUnidad(unidad.getNumeroUnidad());
            unidad1.setEdificio(unidad.getEdificio());
            unidad1.setPiso(unidad.getPiso());
            unidad1.setHabitada(unidad.isHabitada());
            unidad1.setAlquilada(unidad.isAlquilada());
            unidad1.setUsuario(unidad.getUsuario());
            unidad1.setReclamos(unidad.getReclamos());

            unidadDAO.save(unidad1);

        }
    }

    @Override
    public void deleteById(Long id) {
        unidadDAO.delete(id);
    }
}
