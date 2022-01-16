package com.example.nhs_handover_backend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "Patient")
public class Patient extends Person {
    private String patientLocation;
    private String numMRN;

    public Patient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
        super(nameIn,DOBIn,sexIn);
        patientLocation= patientLocationIn;
        numMRN=numMRNIn;
    }

    public String getNumMRN(){
        return numMRN;
    }

    public String getPatientLocation(){
        return patientLocation;
    }

    public void setPatientLocation(String patLoc){
        patientLocation=patLoc;
    }
}