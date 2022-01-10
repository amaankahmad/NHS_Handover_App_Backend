package com.example.nhs_handover_backend;

import com.example.nhs_handover_backend.Entities.JuniorDoctor ;
import com.example.nhs_handover_backend.Entities.Patient ;
import com.example.nhs_handover_backend.Entities.SingletonDatabase;
import com.example.nhs_handover_backend.Entities.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

public class TestJuniorDoctor {

    JuniorDoctor jDoc;
    String name1 = "Kevin Lanera" ;
    String DOB1 = "23/07/1993" ;
    String sex1 = "Male" ;
    String Email1 = "Kevinlanera@gmail.com" ;
    String numPager1 = "123" ;

    Patient pat;
    String name2 = "Karl Cooper" ;
    String DOB2 = "27/06/1998" ;
    String sex2 = "Male" ;
    String numMRNIn = "12364" ;
    String location1 = "Imperial College London";
    String location2 = "RSM";

    Task task1;
    String seniorityRequired1 = "FY";
    String additionalNotes1 = "Junior Doctor Task";
    String history1 = "";
    String time1 = "19:40";
    String taskDes = "Blood Test Junior Doctor";

    Task task2;
    String seniorityRequired2 = "SHO";
    String additionalNotes2 = "SHO Task";
    String history2 = "";
    String time2 = "18:20";
    String taskDes2 = "Blood Test SHO";

    SingletonDatabase db = SingletonDatabase.getInstance();


    ArrayList<Task> allTasks;
    ArrayList<Task> tasksJuniorDoctor;

    @BeforeEach
    public void setUp(){

        db.reset();
        db.createJrDoctor(name1,DOB1,sex1,Email1,numPager1);
        jDoc = db.getJrDoctorList().get(0);

        db.createPatient(name2, DOB2, sex2, location2, numMRNIn);
        pat = db.getPatientList().get(0);

        db.createTask(pat, seniorityRequired1, additionalNotes1, history1, taskDes, time1);
        task1 = db.getCurrTaskList().get(0);
        db.createTask(pat, seniorityRequired2, additionalNotes2, history2, taskDes2, time2);
        task2 = db.getCurrTaskList().get(1);

        tasksJuniorDoctor = new ArrayList<Task>();
        tasksJuniorDoctor.add(task1);

        allTasks = new ArrayList<Task>();
        allTasks.add(task1);
        allTasks.add(task2);

    }


//    @Test
//    public void takeUpTask(){
//
//        ArrayList<Task> dbJDTasks = jDoc.takeUpTask(jDoc);
//
//        for (int i = 0; i < dbJDTasks.size(); i++) {
//            Assertions.assertEquals(dbJDTasks.get(i), tasksJuniorDoctor.get(i));
//        }
//
//    }
//    @Test
//    public void testGetTasks(){
//
//        ArrayList<Task> dbTasks = jDoc.getTasks();
//
//        for (int i = 0; i < dbTasks.size(); i++) {
//            Assertions.assertEquals(dbTasks.get(i), allTasks.get(i));
//        }
//    }

}