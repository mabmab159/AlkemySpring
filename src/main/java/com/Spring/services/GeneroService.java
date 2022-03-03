package com.Spring.services;

import com.Spring.DAO.GeneroDAO;
import com.Spring.models.Genero;
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
public class GeneroService implements GeneroDAO {

    @Autowired
    private GeneroDAO generoDAO;

    @Override
    public List<Genero> findAll() {
        return generoDAO.findAll();
    }

    @Override
    public List<Genero> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Genero> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Genero> findAllById(Iterable<Integer> integers) {
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
    public void delete(Genero entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Genero> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Genero> S save(S entity) {
        return generoDAO.save(entity);
    }

    @Override
    public <S extends Genero> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Genero> findById(Integer integer) {
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
    public <S extends Genero> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Genero> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Genero> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Genero getOne(Integer integer) {
        return null;
    }

    @Override
    public Genero getById(Integer integer) {
        return generoDAO.getById(integer);
    }

    @Override
    public <S extends Genero> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Genero> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Genero> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Genero> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Genero> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Genero> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Genero, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
