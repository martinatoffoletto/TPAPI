package com.example.demo.controller;


import com.example.demo.model.dao.UsuarioDAOImpl;
import com.example.demo.model.entity.Unidad;
import com.example.demo.model.entity.UnidadDTO;
import com.example.demo.model.entity.Usuario;
import com.example.demo.model.entity.UsuarioDTO;
import com.example.demo.service.IUsuarioService;
import com.example.demo.service.UsuarioServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Date;


@RestController
@RequestMapping(value = "/auth", method = RequestMethod.GET)
public class IngresoController {
    private final int EXPIRATION_TIME_IN_MIN = 1;


    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private SecretKey secretKey;

    @Autowired
    private UsuarioDAOImpl usuarioDAO;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioDTO credentials) {
        if (usuarioService.findByUsuario(credentials.getNombreUsuario(), credentials.getContrasenia()) != null) {
            String token = Jwts.builder().setSubject(credentials.getNombreUsuario())
                    .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MIN * 60 * 1000))
                    .signWith(secretKey, SignatureAlgorithm.HS256).compact();

            return new ResponseEntity<>(token, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(value = "/registro")
    public ResponseEntity<String> registro(@RequestBody UsuarioDTO credenciales){

        Usuario usuario = new Usuario(credenciales.getNombreUsuario(), credenciales.getApellido(), credenciales.getDni(), credenciales.getNombreUsuario(),
                credenciales.getContrasenia(), credenciales.getTipoUsuario());

        //hay que ponerlo así en json
        //{
        //    "Nombre":"Lara",
        //    "apellido":"Jean",
        //    "dni":19876345,
        //    "nombreUsuario":"larajean",
        //    "contrasenia":"1234",
        //    "tipoUsuario":"DUENIO"
        //}

        usuarioDAO.save(usuario);



        String token = Jwts.builder().setSubject(credenciales.getNombreUsuario())
                .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MIN * 60 * 1000))
                .signWith(secretKey, SignatureAlgorithm.HS256).compact();;
        return new ResponseEntity<>(token, HttpStatus.OK);
    }


}
