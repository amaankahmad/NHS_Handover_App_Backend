package com.example.nhs_handover_backend.Controllers;
import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


}
