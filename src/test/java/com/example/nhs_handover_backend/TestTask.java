package com.example.nhs_handover_backend;

import com.example.nhs_handover_backend.Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestTask {

    ArrayList<Task> tasks;

    JuniorDoctor doc;
    String name1 = "Peter James";
    String DOB1 = "20/08/1975";
    String sex1 = "Male";
    String email1= "peter.james@gmail.com";
    String numPager1= "123456";


    Patient pat;
    String name2 = "Amaan Ahmad";
    String DOB2 = "27/01/2001";
    String sex2 = "Male";
    String numMRN2 = "123456";
    String location2 = "Imperial College London";


    Patient pat3 = pat;
    JuniorDoctor doctorOfTask1;
    String senior3 = "Consultant";
    String notes3 = "family history of diabetes";
    String history3 = "previous task done: blood test and ECG";
    String time3 = "13:24";
    String taskDescript3 = "clinical review";
    Boolean status3 = false;
    String covidStatus3 = "Positive";
    String duraton3 = "3 hours";
    String urgency3 = "urgent";
    Task t= new Task(pat,"Consultant","family history of diabetes","previous task done: blood test and ECG","clinical review","13:24","3 hours","Positive","urgent");

    // Set Doctor of Task Test
    @Test
    public void testSetDoctorOfTask(){
        t.setDoctorOfTask(doc);
        Assertions.assertEquals(doctorOfTask1,t.getDoctorOfTask());
    }

    @Test
    public void testGetDoctorOfTask(){
        t.setDoctorOfTask(doc);
        Assertions.assertEquals(doctorOfTask1,t.getDoctorOfTask());
    }

    // Get Task Time of Creation Test
    @Test
    public void testGetTime(){
        Assertions.assertEquals(time3,t.getTime());
    }

    // Get Task Info Test
    @Test
    public void testGetTaskInfo(){
        String[] res={notes3, history3};
        Assertions.assertEquals(res[0],t.getTaskInfo()[0]);
        Assertions.assertEquals(res[1],t.getTaskInfo()[1]);
    }

    // Get Task Patient Test
    @Test
    public void testGetPatient(){
        Assertions.assertEquals(pat3,t.getPatient());
    }

    // Get Task Description Test
    @Test
    public void testGetTaskDescript(){
        Assertions.assertEquals(taskDescript3,t.getTaskDescript());
    }

    // Get Task Seniority Required Test
    @Test
    public void testGetSeniorityRequired(){
        Assertions.assertEquals(senior3,t.getSeniorityRequired());
    }

}

