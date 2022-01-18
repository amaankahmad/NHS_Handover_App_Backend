package com.example.nhs_handover_backend.Entities;

import javax.persistence.*;

@Entity (name = "Person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String name;
    private String DOB;
    private String sex;

    public Person(String nameIn, String DOBIn, String sexIn) {
        name= nameIn;
        DOB = DOBIn;
        sex=sexIn;
    }

    public Person() {
        name = "tbd";
        DOB = "tbd";
        sex = "tbd";
    }

    public String getName(){
        return name;
    }

    public String getSex(){
        return sex;
    }

    public String getDOB(){
        return DOB;
    }
}