package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient(Patient patient){
//        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        patientRepository.save(patient);
    }
}
