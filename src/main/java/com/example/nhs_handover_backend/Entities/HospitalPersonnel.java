package com.example.nhs_handover_backend.Entities;

import com.example.nhs_handover_backend.Controllers.HospitalPersonnelController;
import com.example.nhs_handover_backend.Controllers.TaskController;
import com.example.nhs_handover_backend.Repositories.TaskRepository;
import com.example.nhs_handover_backend.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.persistence.*;
import java.util.Optional;

@Entity (name = "HospitalPersonnel")
@Inheritance(strategy = InheritanceType.JOINED)
public class HospitalPersonnel extends Person{
    //    @Id
//    private long id;
    private String email;
    private String numPager;
//    SingletonDatabase db = SingletonDatabase.getInstance();
//    @Resource (name = "TaskRepository")
//    @Autowired
//    private TaskRepository taskRepository;

////    @Resource (name="TaskService")
//
//    private transient TaskService taskService = new TaskService(taskRepository);
//    private transient TaskController taskController = new TaskController(taskService);
//    @Autowired
//    TaskController taskController;
//    private transient HospitalPersonnelController hospitalPersonnelController;

    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        super(nameIn, DOBIn, sexIn);
//        email = emailIn;
//        numPager = numPagerIn;
//        TaskRepository repo = ctx.getBean("");
//        MyClass myclass = new MyClass(repo)
//        return myclass;
    }

    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn) {
        super(nameIn, DOBIn, sexIn);
    }


    public String getNumPager(){
        return  numPager;
    }

    public String getEmail(){
        return email;
    }

//    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
////        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
//    }
//
//    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
//        //        db.createTask(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
////        Task task = new Task(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
////        taskRepository.save(task);
//    }
}