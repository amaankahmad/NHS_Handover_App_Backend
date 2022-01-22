package com.example.nhs_handover_backend.Entities;

import javax.persistence.*;

@Entity (name = "HospitalPersonnel")
//@Inheritance(strategy = InheritanceType.JOINED)
public class HospitalPersonnel extends Person{
    private String email;
    private String numPager;
    private String password;
    private String role;


    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn,
                             String passwordIn, String roleIn) {
        super(nameIn, DOBIn, sexIn);
        email = emailIn;
        numPager = numPagerIn;
        password= passwordIn;
        role = roleIn;
    }

    public HospitalPersonnel() {
        super("TBD","TBD","TBD");
        email = "TBD";
        numPager = "TBD";
        password= "TBD";
        role = "TBD";
    }

    public String getNumPager(){
        return  numPager;
    }

    public String getEmail(){
        return email;
    }

    public String getRole(){
        return role;
    }

    public String getPassword(){return password;}
}