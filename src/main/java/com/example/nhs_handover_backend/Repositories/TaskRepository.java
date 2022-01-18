package com.example.nhs_handover_backend.Repositories;
import com.example.nhs_handover_backend.Entities.Doctor;
import com.example.nhs_handover_backend.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

//    public Iterable<Task> findAllByStatus(Iterable<Boolean> booleans) {
//        return null;
//    }
//    public void findstuff(){
//        var query= ""
//    }
    public ArrayList<Task> findByStatus(Boolean bool);
    public ArrayList<Task> findByStatusOrderByDoctorOfTask(Boolean bool);
    public ArrayList<Task> findByDoctorOfTaskOrderByCreationTime(Doctor doc);
    public ArrayList<Task> findBySeniorityRequired(String seniority);
    //public void updateStatus(@Param("id") Long id, @Param("status") Boolean status);
}
