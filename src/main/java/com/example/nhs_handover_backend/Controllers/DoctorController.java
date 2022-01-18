package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.DoctorService;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    private final TaskService taskService;
    @Autowired
    public DoctorController(TaskService taskService) {
        this.taskService = taskService;
    }

    public void createFollowUpTask(Task oldTask, String seniorIn, String notesIn, String taskDescriptIn, String creationTimeIn){
//        db.createFollowUp(oldTask, seniorIn, notesIn, taskDescriptIn, creationTimeIn);
    }

//    public void archiveTask(Task task){
//        Long id = task.getId();
//        taskService.archiveTask(id);
//    }
}
