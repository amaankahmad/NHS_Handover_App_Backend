package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Entities.Doctor;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.ConsultantService;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ConsultantController {
    private final ConsultantService consultantService;

    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }


    public ArrayList<Task> getTasks(){
        // Returns all tasks not completed
//        return db.getCurrTaskList();
        return consultantService.getTasks();
    }

    public ArrayList<Task> getCompletedTasks(){
        // Returns all tasks completed
//        return db.getDoneTaskList();
        return consultantService.getCompletedTasks();
    }

    public ArrayList<Task> getAllTasks(){
        // Returns all tasks completed and not completed
//        ArrayList<Task> todo = getTasks();
//        ArrayList<Task> done = getCompletedTasks();
//        todo.addAll(done);
//
//        return todo;
        return consultantService.getAllTasks();
    }

    public ArrayList<Task> getDoctorTasks(){
        //Returns all doctors current tasks
//        return db.getDoctorTasks();
        return consultantService.getDoctorTasks();
    }

    public ArrayList<Task> getDoctorTasks(Doctor doc) {
        //– if argument then returns tasks for specific doctor
//        return db.getDoctorTasks(doc);
        return consultantService.getDoctorTasks(doc);
    }
}
