package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Repositories.PatientRepository;
import com.example.nhs_handover_backend.Repositories.PatientRepositoryImplementer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class PatientServiceImplementer {
    @Autowired
    private PatientRepositoryImplementer patientRepositoryImplementer = new PatientRepositoryImplementer();
    @Autowired
    public PatientServiceImplementer(PatientRepository patientRepository) {
        this.patientRepositoryImplementer = patientRepositoryImplementer;
    }

    public Patient addPatient(Patient pat) {
        patientRepositoryImplementer.save(pat);
        return pat;
    }

    public ArrayList<Patient> getAllPatients(){
        return (ArrayList<Patient>) patientRepositoryImplementer.findAll();
    }
}
