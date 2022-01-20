package com.example.nhs_handover_backend.Entities;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Consultant extends Doctor {
//    SingletonDatabase db = SingletonDatabase.getInstance();

    public Consultant(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public Consultant() {
        super("tbd","tbd","tbd","tbd","tbd");
    }

    public ArrayList<Task> getTasks(){
        // Returns all tasks not completed
//        return db.getCurrTaskList();
        return null;
    }

    public ArrayList<Task> getCompletedTasks(){
        // Returns all tasks completed
//        return db.getDoneTaskList();
        return null;
    }

    public ArrayList<Task> getAllTasks(){
        // Returns all tasks completed and not completed
//        ArrayList<Task> todo = getTasks();
//        ArrayList<Task> done = getCompletedTasks();
//        todo.addAll(done);
//
//        return todo;
        return null;
    }

    public ArrayList<ArrayList<Task>> getDoctorTasks(){
        //Returns all doctors current tasks
//        return db.getDoctorTasks();
        return null;
    }

    public ArrayList<Task> getDoctorTasks(Doctor doc) {
        //– if argument then returns tasks for specific doctor
//        return db.getDoctorTasks(doc);
        return null;
    }
}