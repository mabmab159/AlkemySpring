package com.Spring.modelsAuxiliar;

import com.Spring.models.Pelicula;
import com.Spring.models.Personaje;

import java.util.List;

public class PersonajeVisualizar extends Personaje {
    private int idPersonaje;
    private byte[] imagen;
    private String nombre;
    private int edad;
    private float peso;
    private String historia;
    private List<Pelicula> peliculas;

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idpersonaje) {
        this.idPersonaje = idpersonaje;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
