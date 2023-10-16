package com.example.demo.service;

import com.example.demo.model.entity.Foto;

public interface IFotoService {
    public Foto findById(Long id);
    public void save(Foto usuario);
}
