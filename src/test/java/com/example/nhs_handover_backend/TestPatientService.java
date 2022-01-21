package com.example.nhs_handover_backend;
import com.example.nhs_handover_backend.Repositories.HospitalPersonnelRepositoryImplementer;
import com.example.nhs_handover_backend.Repositories.PatientRepository;
import com.example.nhs_handover_backend.Repositories.PatientRepositoryImplementer;
import com.example.nhs_handover_backend.Services.PatientService;
import com.example.nhs_handover_backend.Services.PatientServiceImplementer;
import org.junit.jupiter.api.Test;
import com.example.nhs_handover_backend.Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TestPatientService {
    @Autowired
    private PatientServiceImplementer patientServiceImplementer;

    @MockBean
    private PatientRepositoryImplementer patientRepositoryImplementer = new PatientRepositoryImplementer();

    @Test
    public void getAllPatientsTest(){
        when(patientRepositoryImplementer.findAll()).thenReturn(Stream.of( new Patient("Nathan","DOB","Male","L01","0776589")).collect(Collectors.toList()));
        Assertions.assertEquals(1,patientServiceImplementer.getAllPatients().size());
    }


    // need to make addPatient return patient object for this test to work
    @Test
    public void addPatientTest() {
        Patient patient = new Patient("Nathan", "DOB", "Male", "L01", "0776589");
        when(patientRepositoryImplementer.save(patient)).thenReturn(patient);
        Assertions.assertEquals(patient, patientServiceImplementer.addPatient(patient));
    }

}