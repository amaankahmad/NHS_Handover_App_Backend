package com.example.nhs_handover_backend.Entities;
import javax.persistence.Entity;

@Entity
public class Consultant extends HospitalPersonnel {

    public Consultant(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn, String passwordIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn, passwordIn, "Consultant");
    }

    public Consultant() {
        super("TBD","TBD","TBD","TBD","TBD",
                "TBD", "Consultant");
    }

}