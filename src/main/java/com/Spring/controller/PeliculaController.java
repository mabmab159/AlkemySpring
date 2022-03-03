package com.Spring.controller;

import com.Spring.models.Pelicula;
import com.Spring.models.PeliculaPersonaje;
import com.Spring.models.Personaje;
import com.Spring.modelsAuxiliar.PeliculaAuxiliar;
import com.Spring.modelsAuxiliar.PeliculaVisualizar;
import com.Spring.services.GeneroService;
import com.Spring.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private GeneroService generoService;

    @GetMapping("/movies")
    public ResponseEntity<List<PeliculaAuxiliar>> obtenerPeliculas(@RequestParam(required = false, name = "name") String name, @RequestParam(required = false, name = "genre") Integer genre, @RequestParam(required = false, name = "order") String order) {
        List<Pelicula> peliculas = new ArrayList<>();
        if (name == null && genre == null && order == null) {
            peliculas = peliculaService.findAll();
        }
        if (!(name == null)) {
            peliculas = peliculaService.buscarPeliculaPorNombre(name);
        }
        if (!(genre == null)) {
            peliculas = peliculaService.buscarPeliculaPorGenero(genre);
        }
        if (!(order == null)) {
            if (order.equals("ASC")) {
                peliculas = peliculaService.buscarPeliculaPorOrden();
            }
            if (order.equals("DESC")) {
                peliculas = peliculaService.buscarPeliculaPorOrden2();
            }

        }

        List<PeliculaAuxiliar> resultado = new ArrayList<>();
        for (int i = 0; i < peliculas.size(); i++) {
            PeliculaAuxiliar peliculaAuxiliar = new PeliculaAuxiliar();
            peliculaAuxiliar.setTitulo(peliculas.get(i).getTitulo());
            peliculaAuxiliar.setImagen(peliculas.get(i).getImagen());
            peliculaAuxiliar.setFechaDeCreacion(peliculas.get(i).getFechaDeCreacion());
            resultado.add(peliculaAuxiliar);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    // Realizar CRUD
    // Create
    @PostMapping("/movie/create")
    public ResponseEntity<Pelicula> crearPelicula(@RequestParam("imagen") MultipartFile imagen, @RequestParam("titulo") String titulo, @RequestParam("calificacion") Integer calificacion, @RequestParam("fechadecreacion") Date fechadecreacion, @RequestParam("idgenero") int idgenero) throws IOException {
        Pelicula pelicula = new Pelicula();
        pelicula.setImagen(imagen.getBytes());
        pelicula.setTitulo(titulo);
        pelicula.setCalificacion(calificacion);
        pelicula.setFechaDeCreacion(fechadecreacion);
        pelicula.setGenero(generoService.getById(idgenero));
        peliculaService.save(pelicula);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Read
    @GetMapping("/movie/{id}")
    public ResponseEntity<PeliculaVisualizar> obtenerPelicula(@PathVariable("id") Integer id) {
        List<PeliculaPersonaje> peliculaPersonajes = peliculaService.buscarPelicula(id);
        PeliculaVisualizar auxiliar = new PeliculaVisualizar();
        List<Personaje> personajes = new ArrayList<>();
        for (int i = 0; i < peliculaPersonajes.size(); i++) {
            auxiliar.setIdPelicula(peliculaPersonajes.get(i).getPelicula().getIdPelicula());
            auxiliar.setTitulo(peliculaPersonajes.get(i).getPelicula().getTitulo());
            auxiliar.setImagen(peliculaPersonajes.get(i).getPelicula().getImagen());
            auxiliar.setCalificacion(peliculaPersonajes.get(i).getPelicula().getCalificacion());
            auxiliar.setGenero(peliculaPersonajes.get(i).getPelicula().getGenero());
            auxiliar.setFechaDeCreacion(peliculaPersonajes.get(i).getPelicula().getFechaDeCreacion());
            personajes.add(peliculaPersonajes.get(i).getPersonaje());
        }
        auxiliar.setPersonajes(personajes);
        return new ResponseEntity<>(auxiliar, HttpStatus.OK);
    }

    // Update
    @PutMapping("/movie/edit/{id}")
    public ResponseEntity<Pelicula> editarPelicula(@PathVariable("id") Integer id, @RequestParam("imagen") MultipartFile imagen, @RequestParam("titulo") String titulo, @RequestParam("calificacion") Integer calificacion, @RequestParam("fechadecreacion") Date fechadecreacion, @RequestParam("idgenero") int idgenero) throws IOException {
        Pelicula pelicula = new Pelicula();
        pelicula.setImagen(imagen.getBytes());
        pelicula.setTitulo(titulo);
        pelicula.setCalificacion(calificacion);
        pelicula.setFechaDeCreacion(fechadecreacion);
        pelicula.setIdPelicula(id);
        pelicula.setGenero(generoService.getById(idgenero));
        peliculaService.save(pelicula);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/movie/delete/{id}")
    public ResponseEntity<Pelicula> eliminarPelicula(@PathVariable("id") Integer id) {
        peliculaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
