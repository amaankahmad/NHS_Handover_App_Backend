package com.example.nhs_handover_backend.Repositories;
import com.example.nhs_handover_backend.Entities.Doctor;
import com.example.nhs_handover_backend.Entities.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;
@Transactional
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    public ArrayList<Task> findByStatus(Boolean bool);
    public ArrayList<Task> findByStatusOrderByDoctorOfTask(Boolean bool);
    public ArrayList<Task> findByDoctorOfTaskIdOrderByCreationTime(Long id);
    public ArrayList<Task> findBySeniorityRequired(String seniority);
    @Modifying
    @Query("update Task u set u.status = TRUE where u.id = :id")
    void archiveTask(Long id);
    @Modifying
    @Query("update Task u set u.doctorOfTask = :doctorOfTask where u.id = :id")
    void takeUpTask(Doctor doc, Long id);
}
