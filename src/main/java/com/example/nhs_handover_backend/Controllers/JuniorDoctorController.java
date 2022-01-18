package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Entities.Doctor;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.JuniorDoctorService;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/junior_doctor/")
public class JuniorDoctorController {
    @Autowired
    private final TaskService taskService;

    @Autowired
    public JuniorDoctorController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/takeUpTask")
    public ArrayList<Task> takeUpTask(Doctor doc){
        //assigns task to themselves
//        return db.getDoctorTasks(doc);
        taskService.takeUpTask(doc);
        return null;
    }

    @GetMapping("/getJuniorDoctorTasks")
    public ArrayList<Task> getJuniorDoctorTasks(){
//        //Returns all task available to junior doctor, by calling the task model
////        return db.getCurrTaskList();
        taskService.getJuniorDoctorTasks();
        return null;
    }
}
