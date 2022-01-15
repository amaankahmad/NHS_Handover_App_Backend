package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Repositories.PatientRepository;
import com.example.nhs_handover_backend.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
//        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        Patient patient = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        patientService.addPatient(patient);
    }
}
