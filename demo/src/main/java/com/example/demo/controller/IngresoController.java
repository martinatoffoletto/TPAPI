package com.example.demo.controller;


import com.example.demo.model.entity.UsuarioDTO;
import com.example.demo.service.IUsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class IngresoController {
    private final int EXPIRATION_TIME_IN_MIN = 1;

    private IUsuarioService usuarioService;

    @Autowired
    private SecretKey secretKey;

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


}
