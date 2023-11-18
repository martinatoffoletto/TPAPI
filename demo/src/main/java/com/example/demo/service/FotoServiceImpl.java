package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.entity.Foto;
import com.example.demo.model.dao.FotoRepository;
import org.springframework.stereotype.Service;

@Service
public class FotoServiceImpl implements IFotoService{

    private FotoRepository fotoRepository;

    @Override
    public Optional<Foto> findById(Long id) {
        return fotoRepository.findById(id);
    }

    @Override
    public Foto save(Foto imagen) {
        fotoRepository.save(imagen);
        return imagen;
    }

}
