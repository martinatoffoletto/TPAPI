package com.example.demo.service;

import com.example.demo.model.entity.Foto;

import java.util.Optional;

public interface IFotoService {
    public Optional<Foto> findById(Long id);
    public Foto save(Foto usuario);
}
