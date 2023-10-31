package com.example.demo.controller;


import com.example.demo.model.entity.Edificio;
import com.example.demo.model.entity.EdificioDTO;
import com.example.demo.service.IEdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class edificiosControllers  {

    private IEdificioService edificioService;

    @GetMapping("/edificios")
    public List<EdificioDTO> findAll() {
        List<Edificio> edificios = edificioService.findAll();
        List<EdificioDTO> edificioDTOS = new ArrayList<>();

        for(Edificio edificio : edificios){
            EdificioDTO edificioDTO = convertToDTO(edificio);
            edificioDTOS.add(edificioDTO);
        }

        return edificioDTOS;
    }


    @GetMapping("/edificios/{edificioId}")
    public ResponseEntity<?> getEdificio(@PathVariable Long edificioId) {
        Edificio edificio = edificioService.findById(edificioId);

        if (edificio == null) {
           String mensaje = "Edificio no encontrado con ID: " + edificioId;
           return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        EdificioDTO edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.OK);

    }


    @GetMapping("/edificiosParam")
    public ResponseEntity<?> getEdificioParam(@RequestParam("edificioId") Long edificioId) {
        Edificio edificio = edificioService.findById(edificioId);

        if (edificio == null) {
            String mensaje = "Edificio no encontrado con ID: " + edificioId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        EdificioDTO edificioDTO = convertToDTO(edificio);
        return new ResponseEntity<>(edificioDTO, HttpStatus.OK);

    }

    @PostMapping("/edificios")
    public ResponseEntity<EdificioDTO> addEdificio(@RequestParam EdificioDTO edificioDTO) {
        Edificio edificio = convertToEntity(edificioDTO);

        edificioService.save(edificio);

        EdificioDTO nuevoEdificioDTO = convertToDTO(edificio);

        return new ResponseEntity<>(nuevoEdificioDTO, HttpStatus.CREATED);
    }

    @PutMapping("/edificios/{edificioId}")
    public ResponseEntity<?> updateEdificio(@PathVariable Long edificioId, @RequestBody EdificioDTO edificioDTO) {
        Edificio edificioOld = edificioService.findById(edificioId);

        if(edificioOld == null){
            String mensaje = "Edificio no encontrado con ID: " + edificioId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        Edificio edificioToUpdate = convertToEntity(edificioDTO);
        edificioService.update(edificioId, edificioToUpdate);

        EdificioDTO edificioUpdatedDTO = convertToDTO(edificioToUpdate);
        return new ResponseEntity<>(edificioUpdatedDTO, HttpStatus.OK);
    }

    @DeleteMapping("edificios/{edificioId}")
    public ResponseEntity<String> deleteEdificio(@PathVariable Long edificioId) {
        Edificio edificio = edificioService.findById(edificioId);

        if (edificio==null) {
            String mensaje = "Edificio no encontrado con ID: "+edificioId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        edificioService.deleteById(edificioId);
        String mensaje = "Edificio eliminado [edificioID: " + edificioId + "]";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }




    private Edificio convertToEntity(EdificioDTO edificioDTO) {
        Edificio edificio = new Edificio();
        edificio.setDireccion(edificioDTO.getDireccion());
        return edificio;
    }


    private EdificioDTO convertToDTO(Edificio edificio) {
        EdificioDTO edificioDTO = new EdificioDTO(edificio.getDireccion());
        return edificioDTO;
    }


}
