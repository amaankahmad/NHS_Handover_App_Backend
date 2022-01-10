package com.example.nhs_handover_backend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class HospitalPersonnel extends Person {
//    @Id
//    private long id;
    private String email;
    private String numPager;
//    SingletonDatabase db = SingletonDatabase.getInstance();

    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        super(nameIn, DOBIn, sexIn);
        email = emailIn;
        numPager = numPagerIn;
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

    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
//        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
    }

    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
//        db.createTask(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
    }
}
