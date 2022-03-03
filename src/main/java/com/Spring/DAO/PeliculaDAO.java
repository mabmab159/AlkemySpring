package com.Spring.DAO;

import com.Spring.models.Pelicula;
import com.Spring.models.PeliculaPersonaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeliculaDAO extends JpaRepository<Pelicula, Integer> {

    @Query("SELECT P FROM PeliculaPersonaje P where P.pelicula.idPelicula= :id")
    List<PeliculaPersonaje> buscarPelicula(@Param("id") Integer id);

    @Query("SELECT P FROM Pelicula P where P.titulo like %:name%")
    List<Pelicula> buscarPeliculaPorNombre(@Param("name") String name);

    @Query("SELECT P FROM Pelicula P where P.genero.idGenero = :genre")
    List<Pelicula> buscarPeliculaPorGenero(@Param("genre") Integer genre);

    @Query("SELECT P FROM Pelicula P order by P.titulo asc")
    List<Pelicula> buscarPeliculaPorOrden();

    @Query("SELECT P FROM Pelicula P order by P.titulo desc ")
    List<Pelicula> buscarPeliculaPorOrden2();

}
