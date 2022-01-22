package com.example.nhs_handover_backend.Repositories;

import com.example.nhs_handover_backend.Entities.Consultant;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class ConsultantRepositoryImplementer implements ConsultantRepository{

    public ConsultantRepositoryImplementer(){

    }
    @Override
    public <S extends Consultant> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Consultant> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Consultant> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Consultant> findAll() {
        return null;
    }

    @Override
    public Iterable<Consultant> findAllById(Iterable<Long> longs) {
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
    public void delete(Consultant entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Consultant> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
