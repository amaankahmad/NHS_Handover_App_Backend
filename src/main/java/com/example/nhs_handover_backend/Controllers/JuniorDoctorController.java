package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Entities.Doctor;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.JuniorDoctorService;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class JuniorDoctorController {
    @Autowired
    private final TaskService taskService;

    @Autowired
    public JuniorDoctorController(TaskService taskService) {
        this.taskService = taskService;
    }

        public ArrayList<Task> takeUpTask(Doctor doc){
        //assigns task to themselves
//        return db.getDoctorTasks(doc);
        taskService.takeUpTask(doc);
        return null;
    }

    public ArrayList<Task> getJuniorDoctorTasks(){
//        //Returns all task available to junior doctor, by calling the task model
////        return db.getCurrTaskList();
        taskService.getJuniorDoctorTasks();
        return null;
    }
}
