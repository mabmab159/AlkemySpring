package com.Spring.controller;

import com.Spring.models.Genero;
import com.Spring.services.GeneroService;
import com.Spring.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping("/gender/create")
    public ResponseEntity<Genero> createGender(@RequestParam("imagen") MultipartFile imagen, @RequestParam("nombre") String nombre) throws IOException {
        Genero genero = new Genero();
        genero.setNombre(nombre);
        genero.setImagen(imagen.getBytes());
        generoService.save(genero);
        return new ResponseEntity<>(genero, HttpStatus.CREATED);
    }

    @GetMapping("/gender/all")
    public ResponseEntity<List<Genero>> generoall() {
        List<Genero> generos = generoService.findAll();
        return new ResponseEntity<>(generos, HttpStatus.OK);
    }
}
