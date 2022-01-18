package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Entities.Doctor;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.ConsultantService;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/consultant/")
public class ConsultantController {
    private final ConsultantService consultantService;
    private final TaskService taskService;

    @Autowired
    public ConsultantController(ConsultantService consultantService, TaskService taskService) {
        this.consultantService = consultantService;
        this.taskService = taskService;
    }

    @RequestMapping("/getTasks")
    public ArrayList<Task> getTasks(){
        // Returns all tasks not completed
//        return db.getCurrTaskList();
        return taskService.getTasks();
        //return "hello1";

    }
    @RequestMapping("/getCompletedTasks")
    public ArrayList<Task> getCompletedTasks(){
        // Returns all tasks completed
//        return db.getDoneTaskList();
       return taskService.getCompletedTasks();
       // return "hello2";
    }

    @RequestMapping("/getAllTasks")
    public ArrayList<Task> getAllTasks(){
        // Returns all tasks completed and not completed
//        ArrayList<Task> todo = getTasks();
//        ArrayList<Task> done = getCompletedTasks();
//        todo.addAll(done);
//
//        return todo;
        return taskService.getAllTasks();
        //return "hello3";
    }

    @RequestMapping("/getDoctorTasks")
    public ArrayList<Task> getDoctorTasks(){
        //Returns all doctors current tasks
//        return db.getDoctorTasks();
        return taskService.getDoctorTasks();
        //return "hello4";
    }

    public ArrayList<Task> getDoctorTasks(Doctor doc) {
        //– if argument then returns tasks for specific doctor
//        return db.getDoctorTasks(doc);
        return taskService.getDoctorTasks(doc);
    }
}