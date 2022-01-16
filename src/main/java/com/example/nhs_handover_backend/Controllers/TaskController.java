package com.example.nhs_handover_backend.Controllers;
import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        //        db.createTask(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
        Task task = new Task(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
        taskService.createTask(task);
    }
}
