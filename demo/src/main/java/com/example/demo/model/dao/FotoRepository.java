package com.example.demo.model.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.entity.Foto;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FotoRepository implements JpaRepository<Foto, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Foto> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Foto> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Foto> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Foto getOne(Long aLong) {
        return null;
    }

    @Override
    public Foto getById(Long aLong) {
        return null;
    }

    @Override
    public Foto getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Foto> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Foto> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Foto> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Foto> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Foto> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Foto> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Foto, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Foto> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Foto> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Foto> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Foto> findAll() {
        return null;
    }

    @Override
    public List<Foto> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Foto entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Foto> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Foto> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Foto> findAll(Pageable pageable) {
        return null;
    }
}
