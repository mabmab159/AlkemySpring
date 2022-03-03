package com.Spring.services;

import com.Spring.DAO.PeliculaPersonajeDAO;
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
public class PeliculaPersonajeService implements PeliculaPersonajeDAO {

    @Autowired
    private PeliculaPersonajeDAO peliculaPersonajeDAO;

    @Override
    public List<PeliculaPersonaje> findAll() {
        return null;
    }

    @Override
    public List<PeliculaPersonaje> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PeliculaPersonaje> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PeliculaPersonaje> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(PeliculaPersonaje entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends PeliculaPersonaje> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PeliculaPersonaje> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PeliculaPersonaje> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PeliculaPersonaje> findById(Integer integer) {
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
    public <S extends PeliculaPersonaje> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PeliculaPersonaje> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PeliculaPersonaje> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PeliculaPersonaje getOne(Integer integer) {
        return null;
    }

    @Override
    public PeliculaPersonaje getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends PeliculaPersonaje> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PeliculaPersonaje> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PeliculaPersonaje> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PeliculaPersonaje> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PeliculaPersonaje> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PeliculaPersonaje> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PeliculaPersonaje, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
