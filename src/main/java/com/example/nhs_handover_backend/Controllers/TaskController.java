package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/tasks/")
public class TaskController {
    @Autowired
    private final PatientService patientService;
    @Autowired
    private final TaskService taskService;

    @Autowired
    public TaskController(PatientService patientService, TaskService taskService) {
        this.patientService = patientService;
        this.taskService = taskService;
    }

    @PostMapping("/createTask")
    public void createTask(@RequestBody Task task){
        System.out.println(task.getPatient().getNumMRN());
        System.out.println(task.getTaskInfo());
        patientService.addPatient(task.getPatient());
        taskService.createTask(task);
    }

//    @PostMapping(path="/createFollowUpTask")
//    public void createFollowUpTask(@PathVariable("oldTask") Task oldTask,@PathVariable("senior") String seniorIn,@PathVariable("notes") String notesIn,@PathVariable("taskDescription") String taskDescriptionIn,@PathVariable("creationTime") String creationTimeIn){
//        taskService.archiveTask(oldTask.getId());
//        String[] pastInfo = taskService.getTaskInfo(oldTask.getId());
//        Patient p = taskService.getPatient(oldTask.getId());
//        notesIn = notesIn + "\nAdditional Notes from Previous Task: \n" + pastInfo[0];
//        Task followUp = new Task(p,seniorIn,notesIn, oldTask.getHistory(), taskDescriptionIn,creationTimeIn);
//        taskService.createTask(followUp);
//    }
//
//    @GetMapping("/archiveTask/{id}")
//    public void archiveTask(@PathVariable("id") Long id){
//        taskService.archiveTask(id);
//    }
}
