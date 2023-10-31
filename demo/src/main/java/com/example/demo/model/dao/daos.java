package com.example.demo.model.dao;

import com.example.demo.model.entity.AreaComun;
import com.example.demo.model.entity.Unidad;
import jakarta.websocket.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface daos {
    public List<Object> gelAll();
    public Object findById(Long id);
    public void save(Object obj);
    public void update(Object obj);
    public  void delete(Long id);

}
