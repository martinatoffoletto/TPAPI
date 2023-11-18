package com.example.demo.model.dao;

import com.example.demo.model.entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FotoRepository extends JpaRepository<Foto, Long> {

}