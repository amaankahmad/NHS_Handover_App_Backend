package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Repositories.PatientRepository;
import com.example.nhs_handover_backend.Repositories.PatientRepositoryImplementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class PatientServiceImplementer {
    @Autowired
    private PatientRepositoryImplementer patientRepositoryImplementer;
    @Autowired
    public PatientServiceImplementer(PatientRepositoryImplementer patientRepositoryImplementerIn) {
        this.patientRepositoryImplementer = patientRepositoryImplementerIn;
    }

    public PatientServiceImplementer() {
        this.patientRepositoryImplementer = new PatientRepositoryImplementer();
    }

    public Patient addPatient(Patient pat) {
        patientRepositoryImplementer.save(pat);
        return pat;
    }

    public ArrayList<Patient> getAllPatients(){
        return (ArrayList<Patient>) patientRepositoryImplementer.findAll();
    }
}
