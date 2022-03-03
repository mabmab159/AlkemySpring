package com.Spring.DAO;

import com.Spring.models.PeliculaPersonaje;
import com.Spring.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonajeDAO extends JpaRepository<Personaje, Integer> {

    @Query("SELECT P FROM PeliculaPersonaje P where P.personaje.idPersonaje = :id")
    List<PeliculaPersonaje> buscarPersonaje(@Param("id") Integer id);

    @Query("SELECT P FROM Personaje P where P.nombre like %:name%")
    List<Personaje> buscarPersonajePorNombre(@Param("name") String name);

    @Query("SELECT P FROM Personaje P where P.edad = :age")
    List<Personaje> buscarPersonajePorEdad(@Param("age") Integer age);

    @Query("SELECT P FROM PeliculaPersonaje P where P.pelicula.idPelicula = :idmovie")
    List<PeliculaPersonaje> buscarPersonajePorPelicula(@Param("idmovie") Integer idmovie);
}
