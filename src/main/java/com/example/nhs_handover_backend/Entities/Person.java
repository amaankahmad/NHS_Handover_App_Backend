package com.example.nhs_handover_backend.Entities;

public class Person {
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
