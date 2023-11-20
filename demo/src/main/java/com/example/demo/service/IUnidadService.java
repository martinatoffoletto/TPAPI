package com.example.demo.service;


import com.example.demo.model.entity.AreaComun;
import com.example.demo.model.entity.Unidad;

import java.util.List;

public interface IUnidadService {

    public List<Unidad> findAll();
    public Unidad findById(Long id);
    public void save(Unidad unidad);
    public void update(Long unidadId, Unidad unidad);
    public void deleteById(Long id);

    public List<Unidad> findPorEdificio(Long idEdificio);

}
