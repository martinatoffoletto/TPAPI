package com.example.demo.controller;


import com.example.demo.model.entity.Usuario;
import com.example.demo.model.entity.UsuarioDTO;
import com.example.demo.service.IUsuarioService;
import com.example.demo.service.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class usuariosController {

    private IUsuarioService usuarioService;

    @GetMapping("/usuarios/todos")
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for(Usuario usuario : usuarios){
            UsuarioDTO usuarioDTO = convertToDTO(usuario);
            usuarioDTOS.add(usuarioDTO);
        }

        return usuarioDTOS;
    }


    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<?> getUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);

        if (usuario == null) {
            String mensaje = "Usuario no encontrado con ID: " + usuarioId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        UsuarioDTO usuarioDTO = convertToDTO(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);

    }


    @GetMapping("/usuarios_Param")
    public ResponseEntity<?> getUsuarioParam(@RequestParam("usuarioId") Long usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);

        if (usuario == null) {
            String mensaje = "Usuario no encontrado con ID: " + usuarioId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        UsuarioDTO usuarioDTO = convertToDTO(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);

    }

    @PostMapping("/usuarios/nuevo")
    public ResponseEntity<UsuarioDTO> addUsuario(@RequestParam UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);

        usuarioService.save(usuario);

        UsuarioDTO nuevoUsuarioDTO = convertToDTO(usuario);

        return new ResponseEntity<>(nuevoUsuarioDTO, HttpStatus.CREATED);
    }

    @PutMapping("/usuarios/{usuarioId}")
    public ResponseEntity<?> updateUsuario(@PathVariable Long usuarioId, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuarioOld = usuarioService.findById(usuarioId);

        if(usuarioOld == null){
            String mensaje = "Usuario no encontrado con ID: " + usuarioId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        Usuario usuarioToUpdate = convertToEntity(usuarioDTO);
        usuarioService.update(usuarioId, usuarioToUpdate);

        UsuarioDTO usuarioUpdatedDTO = convertToDTO(usuarioToUpdate);
        return new ResponseEntity<>(usuarioUpdatedDTO, HttpStatus.OK);
    }

    @DeleteMapping("usuarios/{usuarioId}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);

        if (usuario==null) {
            String mensaje = "Usuario no encontrado con ID: "+usuarioId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        usuarioService.deleteById(usuarioId);
        String mensaje = "Usuario eliminado [usuarioId: " + usuarioId + "]";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }




    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setDni(usuarioDTO.getDni());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setContrasenia(usuarioDTO.getContrasenia());
        usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());
        return usuario;
    }


    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombre(), usuario.getApellido(), usuario.getDni(), usuario.getNombreUsuario(), usuario.getContrasenia(), usuario.getTipoUsuario());
        return usuarioDTO;
    }



}
