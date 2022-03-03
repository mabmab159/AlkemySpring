package com.Spring.services;

import com.Spring.DAO.PersonajeDAO;
import com.Spring.models.PeliculaPersonaje;
import com.Spring.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PersonajeService implements com.Spring.DAO.PersonajeDAO {

    @Autowired
    private PersonajeDAO personajeDAO;

    @Override
    public List<Personaje> findAll() {
        return personajeDAO.findAll();
    }

    @Override
    public List<Personaje> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Personaje> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Personaje> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {
        personajeDAO.deleteById(integer);
    }

    @Override
    public void delete(Personaje entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Personaje> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Personaje> S save(S entity) {
        return personajeDAO.save(entity);
    }

    @Override
    public <S extends Personaje> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Personaje> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Personaje> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Personaje> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Personaje> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Personaje getOne(Integer integer) {
        return null;
    }

    @Override
    public Personaje getById(Integer integer) {
        return personajeDAO.getById(integer);
    }

    @Override
    public <S extends Personaje> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Personaje> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Personaje> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Personaje> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Personaje> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Personaje> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Personaje, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<PeliculaPersonaje> buscarPersonaje(Integer id) {
        return personajeDAO.buscarPersonaje(id);
    }

    @Override
    public List<Personaje> buscarPersonajePorNombre(String name) {
        return personajeDAO.buscarPersonajePorNombre(name);
    }

    @Override
    public List<Personaje> buscarPersonajePorEdad(Integer age) {
        return personajeDAO.buscarPersonajePorEdad(age);
    }

    @Override
    public List<PeliculaPersonaje> buscarPersonajePorPelicula(Integer idmovie) {
        return personajeDAO.buscarPersonajePorPelicula(idmovie);
    }
}
