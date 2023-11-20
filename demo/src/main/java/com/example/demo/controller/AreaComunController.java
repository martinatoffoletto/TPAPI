package com.example.demo.controller;


import com.example.demo.model.entity.AreaComun;
import com.example.demo.model.entity.AreaComunDTO;
import com.example.demo.service.IAreaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/areasComunes")
public class AreaComunController {

    @Autowired
    private IAreaComunService areaComunService;

    @GetMapping("/areasComunesTodas")
    public List<AreaComunDTO> findAll(){
        List<AreaComun> areasComunes = areaComunService.findAll();
        List<AreaComunDTO> acDTOS = new ArrayList<>();

        for (AreaComun areaComun : areasComunes){
            AreaComunDTO areaComunDTO = convertToDTO(areaComun);
            acDTOS.add(areaComunDTO);
        }

        return acDTOS;
    }

    @GetMapping("/areasComunes/{areaCoId}")
    public ResponseEntity<?> getAreaComun(@PathVariable Long areaCoId){
        AreaComun areaComun = areaComunService.findById(areaCoId);

        if (areaComun==null){
            String mensaje = "Area común no encontrada con ID: " + areaCoId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        AreaComunDTO areaComunDTO = convertToDTO(areaComun);
        return new ResponseEntity<>(areaComunDTO, HttpStatus.OK);
    }

    @GetMapping("/areaComunParam")
    public ResponseEntity<?> areaComunParam(@RequestParam("areaCoId") Long areaCoId) {
        AreaComun areaComun = areaComunService.findById(areaCoId);

        if (areaComun == null) {
            String mensaje = "Area Común no encontrada con ID: " + areaCoId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        AreaComunDTO areaComunDTO = convertToDTO(areaComun);
        return new ResponseEntity<>(areaComunDTO, HttpStatus.OK);

    }


    //este mapea por edificio
    @GetMapping("/areasComunesEdificio/{edificioId}")
    public List<AreaComunDTO> areaComunEdificio(@PathVariable Long edificioId){
        List<AreaComun> areasComunes = areaComunService.findPorEdificio(edificioId);
        List<AreaComunDTO> acDTOS = new ArrayList<>();

        for (AreaComun areaComun : areasComunes){
            AreaComunDTO areaComunDTO = convertToDTO(areaComun);
            acDTOS.add(areaComunDTO);
        }

        return acDTOS;
    }




    @PostMapping("/areaComun")
    public ResponseEntity<AreaComunDTO> addAreaComun(@RequestParam AreaComunDTO areaComunDTO) {
        AreaComun areaComun = convertToEntity(areaComunDTO);

        areaComunService.save(areaComun);

        AreaComunDTO nuevaAreaComunDTO = convertToDTO(areaComun);

        return new ResponseEntity<>(nuevaAreaComunDTO, HttpStatus.CREATED);
    }

    @PutMapping("/areaComun/{areaComunId}")
    public ResponseEntity<?> updateAreaComun(@PathVariable Long areaComunId, @RequestBody AreaComunDTO areaComunDTO) {
        AreaComun areaComunOld = areaComunService.findById(areaComunId);

        if(areaComunOld == null){
            String mensaje = "Area Común no encontrada con ID: " + areaComunId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        AreaComun areaComunToUpdate = convertToEntity(areaComunDTO);
        areaComunService.update(areaComunId, areaComunToUpdate);

        AreaComunDTO areaComunToUpdateDTO = convertToDTO(areaComunToUpdate);
        return new ResponseEntity<>(areaComunToUpdateDTO, HttpStatus.OK);
    }


    @DeleteMapping("areaComun/{areaComunId}")
    public ResponseEntity<String> deleteAreaComun(@PathVariable Long areaComunId) {
        AreaComun areaComun = areaComunService.findById(areaComunId);

        if (areaComun==null) {
            String mensaje = "Area común no encontrada con ID: "+areaComunId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        areaComunService.deleteById(areaComunId);
        String mensaje = "Area Común eliminada [areaComunID: " + areaComunId + "]";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }




    private AreaComun convertToEntity(AreaComunDTO areaComunDTO) {
        AreaComun areaComun = new AreaComun();
        areaComun.setNombre(areaComunDTO.getNombre());
        areaComun.setEdificio(areaComunDTO.getEdificio());
        areaComun.setDescripcion(areaComunDTO.getDescripcion());
        return areaComun;
    }


    private AreaComunDTO convertToDTO(AreaComun areaComun) {
        return new AreaComunDTO(areaComun.getNombre(), areaComun.getDescripcion(), areaComun.getEdificio());
    }

}
