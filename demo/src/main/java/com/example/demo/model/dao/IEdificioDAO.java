package com.example.demo.model.dao;

import com.example.demo.model.entity.Edificio;
import java.util.List;

public interface IEdificioDAO {
    public Edificio findEdificio(String direccion);
    public List<Edificio> findAllEdificios();
    public void save(Edificio edificio);
    public void deleteEdificioById(Long id);
}
