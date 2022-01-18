package com.example.nhs_handover_backend.Controllers;
import com.example.nhs_handover_backend.Entities.*;
import com.example.nhs_handover_backend.Services.HospitalPersonnelService;
import com.example.nhs_handover_backend.Services.PatientService;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/hospital_personnel/")
public class HospitalPersonnelController {
    @Autowired
    private HospitalPersonnelService hospitalPersonnelService;
    @Autowired
    private final PatientService patientService;
    @Autowired
    private final TaskService taskService;

    @Autowired
    public HospitalPersonnelController(HospitalPersonnelService hospitalPersonnelService, PatientService patientService,TaskService taskService) {
        this.hospitalPersonnelService = hospitalPersonnelService;
        this.patientService = patientService;
        this.taskService = taskService;
    }

    @GetMapping("/getAllHospitalPersons")
    public ArrayList<HospitalPersonnel> getAllHospitalPersons() {
        //return db.getHospitalPersonList();
        return hospitalPersonnelService.getAllHospitalPersons();
    }

    // Create hospital personnel
    //@PostMapping("/hospital_personnel")
    public void createHospitalPerson(HospitalPersonnel doc) {
        // Directly mapping the post json request body to the HospitalPersonnel object
        //db.createHospitalPersonnel(doc.getName(), doc.getDOB(), doc.getSex(), doc.getEmail(), doc.getNumPager());
        hospitalPersonnelService.createHospitalPersonnel(doc);
    }

   // @PostMapping("/hospital_personnel/addPatient")
    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
//        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        Patient pat = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        patientService.addPatient(pat);
    }

   // @PostMapping("/hospital_personnel/createTask")
    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        Task task = new Task(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
        taskService.createTask(task);
    }
}