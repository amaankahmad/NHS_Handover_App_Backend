package com.example.nhs_handover_backend.Entities;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Consultant extends HospitalPersonnel {
//    SingletonDatabase db = SingletonDatabase.getInstance();

    public Consultant(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public Consultant() {
        super("tbd","tbd","tbd","tbd","tbd");
    }

}