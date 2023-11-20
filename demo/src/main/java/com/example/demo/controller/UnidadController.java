package com.example.demo.controller;


import com.example.demo.model.entity.AreaComun;
import com.example.demo.model.entity.AreaComunDTO;
import com.example.demo.model.entity.Unidad;
import com.example.demo.model.entity.UnidadDTO;
import com.example.demo.service.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadController {

    @Autowired
    private IUnidadService unidadService;

    @GetMapping("/unidadesTodas")
    public List<UnidadDTO> findAll(){
        List<Unidad> unidades = unidadService.findAll();
        List<UnidadDTO> unidadesDTOS = new ArrayList<>();

        for (Unidad unidad : unidades){
            UnidadDTO unidadDTO = convertToDTO(unidad);
            unidadesDTOS.add(unidadDTO);
        }

        return unidadesDTOS;
    }

    @GetMapping("/unidades/{unidadId}")
    public ResponseEntity<?> getUnidad(@PathVariable Long unidadId){
        Unidad unidad = unidadService.findById(unidadId);

        if (unidad==null){
            String mensaje = "Unidad no encontrada con ID: " + unidadId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        UnidadDTO unidadDTO = convertToDTO(unidad);
        return new ResponseEntity<>(unidadDTO, HttpStatus.OK);
    }


    @GetMapping("/unidadParam")
    public ResponseEntity<?> unidadParam(@RequestParam("unidadId") Long unidadId) {
        Unidad unidad = unidadService.findById(unidadId);

        if (unidad == null) {
            String mensaje = "Unidad no encontrada con ID: " + unidadId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        UnidadDTO unidadDTO = convertToDTO(unidad);
        return new ResponseEntity<>(unidadDTO, HttpStatus.OK);

    }

    @PostMapping("/unidades")
    public ResponseEntity<UnidadDTO> addUnidad(@RequestParam UnidadDTO unidadDTO) {
        Unidad unidad = convertToEntity(unidadDTO);

        unidadService.save(unidad);

        UnidadDTO nuevaUnidadDTO = convertToDTO(unidad);

        return new ResponseEntity<>(nuevaUnidadDTO, HttpStatus.CREATED);
    }


    @PutMapping("/unidades/{unidadId}")
    public ResponseEntity<?> updateUnidad(@PathVariable Long unidadId, @RequestBody UnidadDTO unidadDTO) {
        Unidad unidadOld = unidadService.findById(unidadId);

        if(unidadOld == null){
            String mensaje = "Unidad no encontrada con ID: " + unidadId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        Unidad unidadToUpdate = convertToEntity(unidadDTO);
        unidadService.update(unidadId, unidadToUpdate);

        UnidadDTO unidadToUpdateDTO = convertToDTO(unidadToUpdate);
        return new ResponseEntity<>(unidadToUpdateDTO, HttpStatus.OK);
    }


    @DeleteMapping("unidad/{unidadId}")
    public ResponseEntity<String> deleteUnidad(@PathVariable Long unidadId) {
        Unidad unidad = unidadService.findById(unidadId);

        if (unidad==null) {
            String mensaje = "Unidad no encontrada con ID: "+unidadId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        unidadService.deleteById(unidadId);
        String mensaje = "Unidad eliminada [unidadID: " + unidadId + "]";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }





    private Unidad convertToEntity(UnidadDTO unidadDTO) {
        Unidad unidad = new Unidad();
        unidad.setPiso(unidadDTO.getPiso());
        unidad.setNumeroUnidad(unidadDTO.getNumeroUnidad());
        unidad.setAlquilada(unidadDTO.isAlquilada());
        unidad.setHabitada(unidadDTO.isHabitada());
        unidad.setEdificio(unidadDTO.getEdificio1());
        unidad.setUsuario(unidadDTO.getUsuario1());
        return unidad;
    }


    private UnidadDTO convertToDTO(Unidad unidad) {
        return new UnidadDTO(unidad.getPiso(), unidad.getNumeroUnidad(), unidad.isHabitada(), unidad.isAlquilada(), unidad.getEdificio(), unidad.getUsuario());
    }

}
