package com.example.nhs_handover_backend.Controllers;

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

    @GetMapping("/getUncompletedTasks")
    public ArrayList<Task> getAllUncompletedTasks() {
        return taskService.getUncompletedTasks();
    }

    @GetMapping("/getTask/{Id}")
    public Task getTask(@PathVariable Long Id) {
        return taskService.getTask(Id);
    }

    @PostMapping("/createPatient")
    public void createPatient(@RequestBody Patient pat) {
        patientService.addPatient(pat);
    }

    @PostMapping("/createTask/{createdBy}/{urgency}/{seniority}/{history}/{taskDescript}/{covidStatus}/{schedule}/" +
                                "{time}/{notes}")
    public void createTask(@PathVariable String createdBy, @PathVariable String urgency, @PathVariable String seniority,
                           @PathVariable String history, @PathVariable String taskDescript,
                           @PathVariable String covidStatus, @PathVariable String schedule,@PathVariable String time,
                           @PathVariable String notes, @RequestBody Patient pat){
        patientService.addPatient(pat);
        Task task = new Task(pat, seniority, notes, history, taskDescript, time, schedule, covidStatus, urgency, createdBy);
        taskService.createTask(task);
    }

    @PostMapping("/createFollowUpTask")
    public void createTask(@RequestBody Task oldTask, @RequestBody Task newTask){
        taskService.archiveTask(oldTask.getId());
        System.out.println(oldTask.getPatient().getNumMRN());
        System.out.println(oldTask.getTaskInfo());
        taskService.createTask(newTask);
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


//    @PostMapping("/createTask/{task}")
//    public void createTask(@PathVariable("task") Task task){
//        taskService.createTask(task);
//    }
//
//    @RequestMapping(path="/createFollowUpTask/{oldTask}/{senior}/{notes}/{taskDescription}/{creationTime}", method = RequestMethod.GET)
//    public void createFollowUpTask(@PathVariable("oldTask") Task oldTask,@PathVariable("senior") String seniorIn,@PathVariable("notes") String notesIn,@PathVariable("taskDescription") String taskDescriptionIn,@PathVariable("creationTime") String creationTimeIn, @PathVariable("duration") String durationIn, @PathVariable("covidStatus") String covidStatusIn, @PathVariable("urgency") String urgencyIn){
//        taskService.archiveTask(oldTask.getId());
//        String[] pastInfo = taskService.getTaskInfo(oldTask.getId());
//        Patient p = taskService.getPatient(oldTask.getId());
//        notesIn = notesIn + "\nAdditional Notes from Previous Task: \n" + pastInfo[0];
//        Task followUp = new Task(p,seniorIn,notesIn, oldTask.getHistory(), taskDescriptionIn,creationTimeIn, durationIn, covidStatusIn,urgencyIn);
//        taskService.createTask(followUp);
//    }
//
//    @RequestMapping(path="/getSeniority/{emailIn}")
//    public String getSeniority(@PathVariable("emailIn") String emailIn){
//        Long id = hospitalPersonnelService.getIdFromEmail(emailIn);
//        ArrayList<JuniorDoctor> juniorDocList = juniorDoctorService.getAllJuniorDoctors();
//        String seniority = new String("consultant");
//        for (int i=0; i< juniorDocList.size();i++){
//            if (Objects.equals(juniorDocList.get(i).getId(), id)){
//                seniority = "junior doctor";
//            }
//        }
//        return seniority;
//    }
//
//    @GetMapping("/archiveTask/{id}")
//    public void archiveTask(@PathVariable("id") Long id){
//        taskService.archiveTask(id);
//    }
//
//    @GetMapping("/RemoveTask")
//    public void removeTask(@PathVariable("task") Task taskRemoved){
//        taskService.removeTask(taskRemoved);
//    }
//
//    @GetMapping("removeAllTasks")
//    public void removeAllTasks(){
//        taskService.removeAllTasks();
//    }
