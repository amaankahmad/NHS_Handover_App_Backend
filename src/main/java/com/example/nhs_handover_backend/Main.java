package com.example.nhs_handover_backend;

//import com.example.nhs_handover_backend.Entities.SingletonDatabase;
import com.example.nhs_handover_backend.Entities.HospitalPersonnel;

public class Main {
    public static void main(String[] args) {
        //SingletonDatabase hospitalDB = SingletonDatabase.getInstance();

        String name1 = "Peter James";
        String DOB1 = "20/08/1975";
        String sex1 = "Male";
        String hospitalID1 = "123456";
        String email1= "peter.james@gmail.com";
        String numPager1= "123456";
        String password = "password";

        // Double check that when passing this in a method its passing in the pointer rather creating a new object
        HospitalPersonnel doc = new HospitalPersonnel(name1, DOB1, sex1, email1, numPager1,password);
    }
}
