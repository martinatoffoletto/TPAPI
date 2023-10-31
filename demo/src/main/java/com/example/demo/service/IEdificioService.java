package com.example.demo.service;

import com.example.demo.model.entity.Edificio;

import java.util.List;

public interface IEdificioService {

    public List<Edificio> findAll();

    public Edificio findById(Long id);

    
    public void save(Edificio edificio);
    
    public void update(Long edificioId, Edificio edificio);
    
    public void deleteById(Long id);



}
