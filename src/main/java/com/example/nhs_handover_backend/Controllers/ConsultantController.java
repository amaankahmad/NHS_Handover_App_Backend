package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Entities.JuniorDoctor;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.JuniorDoctorService;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/consultant/")
public class ConsultantController {
    private final TaskService taskService;
    private final JuniorDoctorService juniorDoctorService;

    @Autowired
    public ConsultantController(TaskService taskService, JuniorDoctorService juniorDoctorService) {
        this.taskService = taskService;
        this.juniorDoctorService = juniorDoctorService;
    }

    @GetMapping("/getTasks")
    public ArrayList<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/getCompletedTasks")
    public ArrayList<Task> getCompletedTasks(){
       return taskService.getCompletedTasks();
    }

    @GetMapping("/getAllTasks")
    public ArrayList<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/getOrderedDoctorTasks")
    public ArrayList<Task> getOrderedDoctorTasks(){
        return taskService.getOrderedDoctorTasks();
    }

    @GetMapping("/getAllJuniorDoctors")
    public ArrayList<JuniorDoctor> getAllJuniorDoctors(){
        return juniorDoctorService.getAllJuniorDoctors();
    }

    @GetMapping("/getDoctorTasks")
    public ArrayList<Task> getDoctorTasks(@PathVariable("id") Long id) {
        return taskService.getDoctorTasks(id);
    }
}