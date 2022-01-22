package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    @PostMapping("/createFollowUpTask")
    public void createTask(@RequestBody Task oldTask, @RequestBody Task newTask){
        taskService.archiveTask(oldTask.getId());
        System.out.println(oldTask.getPatient().getNumMRN());
        System.out.println(oldTask.getTaskInfo());
        taskService.createTask(newTask);
    }

    @GetMapping("/getUncompletedTasks")
    public ArrayList<Task> getAllUncompletedTasks() {
        return taskService.getUncompletedTasks();
    }

    @GetMapping("/getTask/{Id}")
    public Task getTask(@PathVariable Long Id) {
        return taskService.getTask(Id);
    }

    @DeleteMapping("archiveTask/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Long id) {
        taskService.archiveTask(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
//
//    @GetMapping("/archiveTask/{id}")
//    public void archiveTask(@PathVariable("id") Long id){
//        taskService.archiveTask(id);
//    }
}
