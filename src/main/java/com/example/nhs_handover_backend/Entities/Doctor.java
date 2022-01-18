package com.example.nhs_handover_backend.Entities;

import java.util.ArrayList;


public abstract class Doctor extends HospitalPersonnel {
//    SingletonDatabase db = SingletonDatabase.getInstance();

    private String nameIn;
    private String emailIn;
//    private SingletonDatabase dbIn;
    public Doctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public Doctor(){
        super("tbd","tbd","tbd","tbd","tbd");
    }

//    public abstract ArrayList<Task> getTasks();

    public String getName(){
        return nameIn;
    }

    public String getEmail() {return emailIn;} //already in hospital personel

//    public void createFollowUpTask(Task oldTask, String seniorIn, String notesIn, String taskDescriptIn, String creationTimeIn){
////        db.createFollowUp(oldTask, seniorIn, notesIn, taskDescriptIn, creationTimeIn);
//    }
//
//    public void archiveTask(Task taskDone){
//        db.archiveTask(taskDone);
//    }

}
