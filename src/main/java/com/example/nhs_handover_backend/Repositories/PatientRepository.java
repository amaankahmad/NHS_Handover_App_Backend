package com.example.nhs_handover_backend.Repositories;

import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
