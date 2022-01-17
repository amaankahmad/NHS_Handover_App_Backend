package com.example.nhs_handover_backend.Controllers;
import com.example.nhs_handover_backend.Entities.*;
import com.example.nhs_handover_backend.Services.HospitalPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/")
public class HospitalPersonnelController {
    private final HospitalPersonnelService hospitalPersonnelService;

    @Autowired
    public HospitalPersonnelController(HospitalPersonnelService hospitalPersonnelService) {
        this.hospitalPersonnelService = hospitalPersonnelService;
    }

//    @GetMapping("/hospital_personnel")
    public ArrayList<HospitalPersonnel> getAllHospitalPersons() {
        //return db.getHospitalPersonList();
        return hospitalPersonnelService.getAllHospitalPersons();
    }

    // Create hospital personnel
//    @PostMapping("/hospital_personnel")
    public void createHospitalPerson(@RequestBody HospitalPersonnel doc) {
        // Directly mapping the post json request body to the HospitalPersonnel object
        //db.createHospitalPersonnel(doc.getName(), doc.getDOB(), doc.getSex(), doc.getEmail(), doc.getNumPager());
        hospitalPersonnelService.createHospitalPersonnel(doc);
    }

//    @PostMapping("/hospital_personnel")
    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
//        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        Patient pat = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        hospitalPersonnelService.addPatient(pat);
    }

//    @PostMapping("/hospital_personnel")
    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        Task task = new Task(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
        hospitalPersonnelService.createTask(task);
    }
}
