package com.Spring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "peliculapersonaje")
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PeliculaPersonaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpeliculapersonaje")
    private int idPeliculaPersonaje;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpelicula", nullable = false, updatable = false)
    private Pelicula pelicula;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpersonaje", nullable = false, updatable = false)
    private Personaje personaje;

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
}
