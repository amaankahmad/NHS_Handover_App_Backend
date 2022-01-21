package com.example.nhs_handover_backend.Repositories;

import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class HospitalPersonnelRepositoryImplementer implements HospitalPersonnelRepository{
    public HospitalPersonnelRepositoryImplementer(){

    }

    @Override
    public <S extends HospitalPersonnel> S save(S entity) {
        return null;
    }

    @Override
    public <S extends HospitalPersonnel> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<HospitalPersonnel> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<HospitalPersonnel> findAll() {
        return null;
    }

    @Override
    public Iterable<HospitalPersonnel> findAllById(Iterable<Long> longs) {
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
    public void delete(HospitalPersonnel entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends HospitalPersonnel> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public ArrayList<HospitalPersonnel> findByEmail(String email) {
        return null;
    }
}
