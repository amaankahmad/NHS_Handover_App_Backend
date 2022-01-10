package com.example.nhs_handover_backend.Entities;

import javax.persistence.*;

@Entity
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
