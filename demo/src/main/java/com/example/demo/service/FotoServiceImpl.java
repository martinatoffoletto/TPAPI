package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.entity.Foto;
import com.example.demo.model.dao.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoServiceImpl implements IFotoService{

    @Autowired
    private FotoRepository fotoRepository;

    @Override
    public Foto findById(Long id) {
        return null;
    }

    @Override
    public void save(Foto usuario) {

    }
}
