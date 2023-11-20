package com.example.demo.service;

import com.example.demo.model.entity.AreaComun;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IAreaComunService {

    public List<AreaComun> findAll();
    public AreaComun findById(Long id);
    public void save(AreaComun areaComun);
    public void update(Long areaComunId, AreaComun areaComun);
    public void deleteById(Long id);

    public List<AreaComun> findPorEdificio(Long idEdificio);

}
