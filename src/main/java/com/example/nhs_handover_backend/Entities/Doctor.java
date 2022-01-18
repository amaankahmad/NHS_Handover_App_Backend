package com.example.nhs_handover_backend.Entities;

public abstract class Doctor extends HospitalPersonnel {

    private String nameIn;
    private String emailIn;

    public Doctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public Doctor(){
        super("tbd","tbd","tbd","tbd","tbd");
    }

    public String getName(){
        return nameIn;
    }

    public String getEmail() {return emailIn;} //already in hospital personel

}
