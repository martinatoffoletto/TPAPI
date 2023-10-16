package com.example.demo.model.dao;

import com.example.demo.model.entity.AreaComun;

import java.util.List;

public interface IAreaComunDAO {
    public List<AreaComun> findAll();

    public AreaComun findById(Long id);

    public void save(AreaComun areaComun);

    public void deleteById(Long id);


}
