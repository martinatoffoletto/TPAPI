package com.example.demo.model.dao;

import com.example.demo.model.entity.Reclamo;
import java.util.List;

public interface IReclamoDAO {
    public List<Reclamo> findAllReclamos();
    public Reclamo findByNumero(Long numeroR);
    public void save(Reclamo reclamo);
    public void deleteByNumero(Long numeroR);
}
