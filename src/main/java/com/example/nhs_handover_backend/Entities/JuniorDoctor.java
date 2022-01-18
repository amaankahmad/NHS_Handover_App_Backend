package com.example.nhs_handover_backend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity (name = "JuniorDoctor")
public class JuniorDoctor extends HospitalPersonnel {

    public JuniorDoctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public JuniorDoctor() {
        super("TBD","TBD","TBD","TBD","TBD");
    }
}