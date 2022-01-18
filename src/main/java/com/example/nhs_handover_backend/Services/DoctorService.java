package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private final TaskRepository taskRepository;

    @Autowired
    public DoctorService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

//    public void archiveTask(Long id) {
//        taskRepository.updateStatus(id,true);
//    }
}
