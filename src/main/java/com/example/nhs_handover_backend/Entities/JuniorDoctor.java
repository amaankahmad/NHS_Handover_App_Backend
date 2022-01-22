package com.example.nhs_handover_backend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity (name = "JuniorDoctor")
public class JuniorDoctor extends HospitalPersonnel {

    public JuniorDoctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn, String passwordIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn, passwordIn, "Junior Doctor");
    }

    public JuniorDoctor() {
        super("TBD","TBD","TBD","TBD","TBD",
                "TBD", "Junior Doctor");
    }
}