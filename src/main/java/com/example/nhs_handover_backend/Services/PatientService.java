package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public void addPatient(Patient pat) {
        patientRepository.save(pat);
    }


}
