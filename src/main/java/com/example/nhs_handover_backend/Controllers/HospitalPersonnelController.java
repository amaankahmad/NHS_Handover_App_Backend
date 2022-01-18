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

    @GetMapping("/getAllPatients")
    public ArrayList<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

     //Create hospital personnel
    @PostMapping("/createHospitalPerson/{doc}")
    public void createHospitalPerson(@PathVariable("doc") HospitalPersonnel doc) {
        // Directly mapping the post json request body to the HospitalPersonnel object
        hospitalPersonnelService.createHospitalPersonnel(doc);
    }

    @PostMapping("/addPatient/{patient}")
    public void addPatient(@PathVariable("patient") Patient patient){
          patientService.addPatient(patient);
    }

    @PostMapping("/createTask/{task}")
    public void createTask(@PathVariable("task") Task task){
        taskService.createTask(task);
    }

    //NOT CORRECT POST MAPPING
    @PostMapping("/createFollowUpTask")
    public void createFollowUpTask(Long oldTaskId, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        String[] pastInfo = taskService.getTaskInfo(oldTaskId);
        Patient p = taskService.getPatient(oldTaskId);
        notesIn = notesIn + "\nAdditional Notes from Previous Task: \n" + pastInfo[0];
        Task task = new Task(p, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
        taskService.createTask(task);
    }

        @GetMapping("/archiveTask/{id}")
        public void archiveTask(@PathVariable("id") Long id){
        taskService.archiveTask(id);
    }
}