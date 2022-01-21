package com.example.nhs_handover_backend.Services;

//import com.example.nhs_handover_backend.Entities.Doctor;
import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Entities.Task;
import com.example.nhs_handover_backend.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ArrayList<Task> getTasks() {
//        ArrayList<Task> allTasks = new ArrayList<>();
//        ArrayList<Task> currentTasks = new ArrayList<>();
//        taskRepository.findAll().forEach(allTasks::add);
//        for (int i = 0; i < allTasks.size(); i++){
//            if (allTasks.get(i).getStatus() == Boolean.FALSE){
//                currentTasks.add(allTasks.get(i));
//            }
//        }
//        return currentTasks;
        return taskRepository.findByStatus(Boolean.FALSE);
    }

    public ArrayList<Task> getCompletedTasks() {
//        ArrayList<Task> allTasks = new ArrayList<>();
//        ArrayList<Task> completedTasks = new ArrayList<>();
//        taskRepository.findAll().forEach(allTasks::add);
//        for (int i = 0; i < allTasks.size(); i++){
//            if (allTasks.get(i).getStatus() == Boolean.TRUE){
//                completedTasks.add(allTasks.get(i));
//            }
//        }
//        return completedTasks;
        return taskRepository.findByStatus(Boolean.TRUE);
    }

    public ArrayList<Task> getAllTasks() {
        return (ArrayList<Task>) taskRepository.findAll();
    }

    public ArrayList<Task> getDoctorTasks(){
        //Returns all doctors current tasks
//        return db.getDoctorTasks();
        //return taskRepository.findByStatusOrderByDoctorOfTask(Boolean.FALSE);
        //ArrayList<Task> arrayList = new ArrayList<>();
        return taskRepository.findByStatusOrderByDoctorOfTask(Boolean.FALSE);
        //return arrayList;
    }

    public ArrayList<Task> getDoctorTasks(Long id) {
        return taskRepository.findByDoctorOfTaskIdOrderByCreationTime(id);
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void takeUpTask(HospitalPersonnel doc, Long id) {
        taskRepository.takeUpTask(doc, id);
    }

    public ArrayList<Task> getJuniorDoctorTasks() {
        return taskRepository.findBySeniorityRequired("junior doctor");
    }

    public Patient getPatient(Long oldTaskId) {
        Task task = taskRepository.findById(oldTaskId).get();;
        return task.getPatient();
    }

    public String[] getTaskInfo(Long oldTaskId) {
        Task task = taskRepository.findById(oldTaskId).get();
        return task.getTaskInfo();
    }

    public void archiveTask(Long id) {
        taskRepository.archiveTask(id);
    }


}
