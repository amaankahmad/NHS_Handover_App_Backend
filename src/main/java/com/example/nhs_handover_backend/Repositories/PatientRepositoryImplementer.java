package com.example.nhs_handover_backend.Repositories;

import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.Patient;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class PatientRepositoryImplementer implements PatientRepository{
    public PatientRepositoryImplementer(){

    }

    @Override
    public <S extends Patient> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Patient> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Patient> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Patient> findAll() {
        return null;
    }

    @Override
    public Iterable<Patient> findAllById(Iterable<Long> longs) {
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
    public void delete(Patient entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Patient> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
