package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService{
    @Autowired
    private TaskRepository taskRepository;

//    @Autowired
//    public TaskService(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }


}
