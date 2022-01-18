package com.example.nhs_handover_backend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity (name = "JuniorDoctor")
public class JuniorDoctor extends HospitalPersonnel {
//    SingletonDatabase db = SingletonDatabase.getInstance();
//
    public JuniorDoctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }
//
    public JuniorDoctor() {
        super("TBD","TBD","TBD","TBD","TBD");
    }
//
//    public ArrayList<Task> takeUpTask(Doctor doc){
//        //assigns task to themselves
////        return db.getDoctorTasks(doc);
//        return null;
//    }
//
//   public ArrayList<Task> getTasks(){
////        //Returns all task available to junior doctor, by calling the task model
//////        return db.getCurrTaskList();
//        return null;
//    }
}