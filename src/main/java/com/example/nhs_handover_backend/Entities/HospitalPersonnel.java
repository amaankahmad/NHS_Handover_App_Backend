package com.example.nhs_handover_backend.Entities;

import javax.persistence.*;

@Entity (name = "HospitalPersonnel")
//@Inheritance(strategy = InheritanceType.JOINED)
public class HospitalPersonnel extends Person{
    private String email;
    private String numPager;


    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        super(nameIn, DOBIn, sexIn);
        email = emailIn;
        numPager = numPagerIn;
    }

    public HospitalPersonnel() {
        super("TBD","TBD","TBD");
        email = "TBD";
        numPager = "TBD";
    }

    public String getNumPager(){
        return  numPager;
    }

    public String getEmail(){
        return email;
    }
}