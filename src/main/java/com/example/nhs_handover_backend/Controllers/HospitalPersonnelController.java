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
//   Make patient with individual parameters instead of patient object
//    @RequestMapping(path="/addPatient/{name}/{dob}/{sex}/{loc}/{mrn}", method = RequestMethod.GET)
//    public void addPatient(@PathVariable("name") String nameIn,@PathVariable("dob") String DOBIn,@PathVariable("sex") String sexIn,@PathVariable("loc") String locationIn,@PathVariable("mrn") String numMRNIn){
//          Patient p = new Patient(nameIn,DOBIn,sexIn,locationIn,numMRNIn);
//        patientService.addPatient(p);
//    }

    @RequestMapping(path="/addPatient/{pat}", method = RequestMethod.GET)
    public void addPatient(@PathVariable("pat") Patient patIn){
        patientService.addPatient(patIn);
    }

    @PostMapping("/createTask/{task}")
    public void createTask(@PathVariable("task") Task task){
        taskService.createTask(task);
    }

    @RequestMapping(path="/createFollowUpTask/{oldTask}/{senior}/{notes}/{taskDescription}/{creationTime}", method = RequestMethod.GET)
    public void createFollowUpTask(@PathVariable("oldTask") Task oldTask,@PathVariable("senior") String seniorIn,@PathVariable("notes") String notesIn,@PathVariable("taskDescription") String taskDescriptionIn,@PathVariable("creationTime") String creationTimeIn){
        taskService.archiveTask(oldTask.getId());
        String[] pastInfo = taskService.getTaskInfo(oldTask.getId());
        Patient p = taskService.getPatient(oldTask.getId());
        notesIn = notesIn + "\nAdditional Notes from Previous Task: \n" + pastInfo[0];
        Task followUp = new Task(p,seniorIn,notesIn, oldTask.getHistory(), taskDescriptionIn,creationTimeIn);
        taskService.createTask(followUp);
    }

    @GetMapping("/archiveTask/{id}")
    public void archiveTask(@PathVariable("id") Long id){
        taskService.archiveTask(id);
    }
}