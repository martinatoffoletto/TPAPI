package com.example.demo.controller;

import com.example.demo.model.entity.Reclamo;
import com.example.demo.model.entity.ReclamoDTO;
import com.example.demo.model.entity.UsuarioDTO;
import com.example.demo.service.IReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reclamos")
public class reclamosController {
    private IReclamoService reclamoService;

    @GetMapping("/reclamosTodos")
    public List<ReclamoDTO> findAll() {
        List<Reclamo> reclamos = reclamoService.findAll();
        List<ReclamoDTO> reclamoDTOS = new ArrayList<>();

        for(Reclamo reclamo : reclamos){
            ReclamoDTO reclamoDTO = convertToDTO(reclamo);
            reclamoDTOS.add(reclamoDTO);
        }

        return reclamoDTOS;
    }


    @GetMapping("/reclamos/{reclamoId}")
    public ResponseEntity<?> getReclamo(@PathVariable Long reclamoId) {
        Reclamo reclamo = reclamoService.findById(reclamoId);

        if (reclamo == null) {
            String mensaje = "Reclamo no encontrado con ID: " + reclamoId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        ReclamoDTO reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);

    }


    @GetMapping("/reclamosParam")
    public ResponseEntity<?> getReclamoParam(@RequestParam("reclamoId") Long reclamoId) {
        Reclamo reclamo = reclamoService.findById(reclamoId);

        if (reclamo == null) {
            String mensaje = "Reclamo no encontrado con ID: " + reclamoId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

       ReclamoDTO reclamoDTO = convertToDTO(reclamo);
        return new ResponseEntity<>(reclamoDTO, HttpStatus.OK);

    }

    @PostMapping("/reclamos")
    public ResponseEntity<ReclamoDTO> addReclamo(@RequestParam ReclamoDTO reclamoDTO) {
        Reclamo reclamo = convertToEntity(reclamoDTO);

        reclamoService.save(reclamo);

        ReclamoDTO nuevoReclamoDTO = convertToDTO(reclamo);

        return new ResponseEntity<>(nuevoReclamoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/reclamos/{reclamoId}")
    public ResponseEntity<?> updateReclamo(@PathVariable Long reclamoId, @RequestBody ReclamoDTO reclamoDTO) {
        Reclamo reclamoOld = reclamoService.findById(reclamoId);

        if(reclamoOld == null){
            String mensaje = "Reclamo no encontrado con ID: " + reclamoId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        Reclamo reclamoToUpdate = convertToEntity(reclamoDTO);
        reclamoService.update(reclamoId, reclamoToUpdate);

        ReclamoDTO reclamoUpdatedDTO = convertToDTO(reclamoToUpdate);
        return new ResponseEntity<>(reclamoUpdatedDTO, HttpStatus.OK);
    }

    @DeleteMapping("reclamos/{reclamoId}")
    public ResponseEntity<String> deleteReclamo(@PathVariable Long reclamoId) {
        Reclamo reclamo = reclamoService.findById(reclamoId);

        if (reclamo==null) {
            String mensaje = "Reclamo no encontrado con ID: "+reclamoId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        reclamoService.deleteById(reclamoId);
        String mensaje = "Reclamo eliminado [reclamoID: " + reclamoId + "]";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }




    private Reclamo convertToEntity(ReclamoDTO reclamoDTO) {
        Reclamo reclamo = new Reclamo();
        reclamo.setUsuario(reclamoDTO.getUsuario());
        reclamo.setDescripcion(reclamoDTO.getDescripcion());
        reclamo.setEstado(reclamoDTO.getEstado());
        return reclamo;
    }


    private ReclamoDTO convertToDTO(Reclamo reclamo) {
        ReclamoDTO reclamoDTO = new ReclamoDTO();
        reclamo.setUsuario(reclamoDTO.getUsuario());
        reclamo.setDescripcion(reclamoDTO.getDescripcion());
        reclamo.setEstado(reclamoDTO.getEstado());
        return reclamoDTO;
    }
}
