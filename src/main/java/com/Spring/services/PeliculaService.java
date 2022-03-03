package com.Spring.services;

import com.Spring.DAO.PeliculaDAO;
import com.Spring.models.Pelicula;
import com.Spring.models.PeliculaPersonaje;
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
public class PeliculaService implements PeliculaDAO {

    @Autowired
    private PeliculaDAO peliculaDAO;

    @Override
    public List<Pelicula> findAll() {
        return peliculaDAO.findAll();
    }

    @Override
    public List<Pelicula> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Pelicula> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Pelicula> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {
        peliculaDAO.deleteById(integer);
    }

    @Override
    public void delete(Pelicula entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Pelicula> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Pelicula> S save(S entity) {
        return peliculaDAO.save(entity);
    }

    @Override
    public <S extends Pelicula> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Pelicula> findById(Integer integer) {
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
    public <S extends Pelicula> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Pelicula> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Pelicula> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pelicula getOne(Integer integer) {
        return null;
    }

    @Override
    public Pelicula getById(Integer integer) {
        return peliculaDAO.getById(integer);
    }

    @Override
    public <S extends Pelicula> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Pelicula> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Pelicula> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Pelicula> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Pelicula> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Pelicula> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Pelicula, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<PeliculaPersonaje> buscarPelicula(Integer id) {
        return peliculaDAO.buscarPelicula(id);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorNombre(String name) {
        return peliculaDAO.buscarPeliculaPorNombre(name);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorGenero(Integer genre) {
        return peliculaDAO.buscarPeliculaPorGenero(genre);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorOrden() {
        return peliculaDAO.buscarPeliculaPorOrden();
    }

    @Override
    public List<Pelicula> buscarPeliculaPorOrden2() {
        return peliculaDAO.buscarPeliculaPorOrden2();
    }
}
