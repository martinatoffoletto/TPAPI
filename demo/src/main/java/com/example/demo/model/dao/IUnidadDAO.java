package com.example.demo.model.dao;
import com.example.demo.model.entity.Unidad;

import java.util.List;

public interface IUnidadDAO {
    public List<Unidad> findAllUnidades();
    public Unidad findUnidadById(Long id);
    public void save(Unidad unidad);
    public void deleteUnidadById(Long id);
}
