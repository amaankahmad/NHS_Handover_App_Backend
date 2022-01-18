package com.example.nhs_handover_backend.Controllers;
import com.example.nhs_handover_backend.Entities.Doctor;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/takeUpTask/{task}/{doc}")
    public void takeUpTask(@PathVariable("task") Task task,@PathVariable("doc") Doctor doc){
        //assigns task to themselves
        Long id = task.getId();
        taskService.takeUpTask(doc,id);
    }

    @GetMapping("/getJuniorDoctorTasks")
    public ArrayList<Task> getJuniorDoctorTasks(){
//      Returns all task available to junior doctor, by calling the task service
        return taskService.getJuniorDoctorTasks();
    }
}
