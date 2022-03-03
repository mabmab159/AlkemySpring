package com.Spring.controller;

import com.Spring.models.Pelicula;
import com.Spring.models.PeliculaPersonaje;
import com.Spring.models.Personaje;
import com.Spring.modelsAuxiliar.PersonajeAuxiliar;
import com.Spring.modelsAuxiliar.PersonajeVisualizar;
import com.Spring.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    //Listado de personaje
    @GetMapping("/characters")
    public ResponseEntity<List<PersonajeAuxiliar>> listadoPersonaje(@RequestParam(required = false, name = "name") String name, @RequestParam(required = false, name = "age") Integer age, @RequestParam(required = false, name = "idmovie") Integer idmovie) {
        List<Personaje> personajes = new ArrayList<>();
        if (name == null && age == null && idmovie == null) {
            personajes = personajeService.findAll();
        }
        if (!(name == null)) {
            personajes = personajeService.buscarPersonajePorNombre(name);
        }
        if (!(age == null)) {
            personajes = personajeService.buscarPersonajePorEdad(age);
        }
        if (!(idmovie == null)) {
            List<PeliculaPersonaje> listado = personajeService.buscarPersonajePorPelicula(idmovie);
            for(int i=0;i<listado.size();i++){
                personajes.add(listado.get(i).getPersonaje());
            }
        }
        List<PersonajeAuxiliar> resultado = new ArrayList<>();
        for (int i = 0; i < personajes.size(); i++) {
            PersonajeAuxiliar personajeAuxiliar = new PersonajeAuxiliar();
            personajeAuxiliar.setImagen(personajes.get(i).getImagen());
            personajeAuxiliar.setNombre(personajes.get(i).getNombre());
            resultado.add(personajeAuxiliar);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    // CRUD
    // Create
    @PostMapping("/character/create")
    public ResponseEntity<Personaje> crearPersonaje(@RequestParam("imagen") MultipartFile imagen, @RequestParam("nombre") String nombre, @RequestParam("edad") Integer edad, @RequestParam("peso") Float peso, @RequestParam("historia") String historia) throws IOException {
        Personaje personaje = new Personaje();
        personaje.setImagen(imagen.getBytes());
        personaje.setNombre(nombre);
        personaje.setEdad(edad);
        personaje.setPeso(peso);
        personaje.setHistoria(historia);
        personajeService.save(personaje);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/character/{id}")
    public ResponseEntity<PersonajeVisualizar> obtenerPersonaje(@PathVariable("id") Integer id) {
        List<PeliculaPersonaje> peliculaPersonajes = personajeService.buscarPersonaje(id);
        PersonajeVisualizar auxiliar = new PersonajeVisualizar();
        List<Pelicula> peliculas = new ArrayList<>();
        for (int i = 0; i < peliculaPersonajes.size(); i++) {
            auxiliar.setIdPersonaje(peliculaPersonajes.get(i).getPersonaje().getIdPersonaje());
            auxiliar.setNombre(peliculaPersonajes.get(i).getPersonaje().getNombre());
            auxiliar.setImagen(peliculaPersonajes.get(i).getPersonaje().getImagen());
            auxiliar.setEdad(peliculaPersonajes.get(i).getPersonaje().getEdad());
            auxiliar.setPeso(peliculaPersonajes.get(i).getPersonaje().getPeso());
            auxiliar.setHistoria(peliculaPersonajes.get(i).getPersonaje().getHistoria());
            peliculas.add(peliculaPersonajes.get(i).getPelicula());
        }
        auxiliar.setPeliculas(peliculas);
        return new ResponseEntity<>(auxiliar, HttpStatus.OK);
    }

    //Edit
    @PutMapping("/character/edit/{id}")
    public ResponseEntity<Personaje> editarPersonaje(@PathVariable("id") Integer id, @RequestParam("imagen") MultipartFile imagen, @RequestParam("nombre") String nombre, @RequestParam("edad") Integer edad, @RequestParam("peso") Float peso, @RequestParam("historia") String historia) throws IOException {
        Personaje personaje = new Personaje();
        personaje.setImagen(imagen.getBytes());
        personaje.setNombre(nombre);
        personaje.setEdad(edad);
        personaje.setPeso(peso);
        personaje.setHistoria(historia);
        personaje.setIdPersonaje(id);
        personajeService.save(personaje);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/character/delete/{id}")
    public ResponseEntity<Personaje> eliminarPersonaje(@PathVariable("id") Integer id) {
        personajeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
