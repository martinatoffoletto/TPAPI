package com.example.demo.service;


import com.example.demo.model.entity.Reclamo;


import java.util.List;

public interface IReclamoService {
    public List<Reclamo> findAll();

    public Reclamo findById(Long id);

    public void save(Reclamo reclamo);

    public void update(Long reclamoId, Reclamo reclamo);

    public void deleteById(Long id);
}
