package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Entities.Doctor;
import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConsultantService {
    @Autowired
    private final TaskRepository taskRepository;

    @Autowired
    public ConsultantService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

//    public ArrayList<Task> getTasks() {
////        ArrayList<Task> allTasks = new ArrayList<>();
////        ArrayList<Task> currentTasks = new ArrayList<>();
////        taskRepository.findAll().forEach(allTasks::add);
////        for (int i = 0; i < allTasks.size(); i++){
////            if (allTasks.get(i).getStatus() == Boolean.FALSE){
////                currentTasks.add(allTasks.get(i));
////            }
////        }
////        return currentTasks;
//        return taskRepository.findByStatus(Boolean.FALSE);
//    }
//
//    public ArrayList<Task> getCompletedTasks() {
////        ArrayList<Task> allTasks = new ArrayList<>();
////        ArrayList<Task> completedTasks = new ArrayList<>();
////        taskRepository.findAll().forEach(allTasks::add);
////        for (int i = 0; i < allTasks.size(); i++){
////            if (allTasks.get(i).getStatus() == Boolean.TRUE){
////                completedTasks.add(allTasks.get(i));
////            }
////        }
////        return completedTasks;
//        return taskRepository.findByStatus(Boolean.TRUE);
//    }
//
//    public ArrayList<Task> getAllTasks() {
//        ArrayList<Task> arrayList = new ArrayList<>();
//        taskRepository.findAll().forEach(arrayList::add);
//        return arrayList;
//    }
//
//    public ArrayList<Task> getDoctorTasks(){
//        //Returns all doctors current tasks
////        return db.getDoctorTasks();
//        //return taskRepository.findByStatusOrderByDoctorOfTask(Boolean.FALSE);
//        ArrayList<Task> arrayList = new ArrayList<>();
//        taskRepository.findByStatusOrderByDoctorOfTask(Boolean.FALSE).forEach(arrayList::add);
//        return arrayList;
//    }
//
//    public ArrayList<Task> getDoctorTasks(Doctor doc) {
//        //– if argument then returns tasks for specific doctor
////        return db.getDoctorTasks(doc);
//        //return taskRepository.findByDoctorOfTaskOrderByCreationTime(doc);
//        ArrayList<Task> arrayList = new ArrayList<>();
//        taskRepository.findByDoctorOfTaskOrderByCreationTime(doc).forEach(arrayList::add);
//        return arrayList;
//    }
}