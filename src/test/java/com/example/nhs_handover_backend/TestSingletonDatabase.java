package com.example.nhs_handover_backend;

import com.example.nhs_handover_backend.Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestSingletonDatabase {
    Consultant c;
    String name = "Amaan Ahmad";
    String DOB = "27/01/2001";
    String sex = "Male";
    String email = "amaan@imperial.ac.uk";
    String numPager = "0234918321";

    JuniorDoctor d1;
    String name1 = "Sacha Avey";
    String DOB1 = "01/01/2001";
    String sex1 = "Female";
    String email1 = "sacha@imperial.ac.uk";
    String numPager1 = "4532464536";

    JuniorDoctor d2;
    String name2 = "Sacha Avey";
    String DOB2 = "01/01/2001";
    String sex2 = "Female";
    String email2 = "sacha@imperial.ac.uk";
    String numPager2 = "4532464536";

    Patient pat;
    String name3 = "Nathan Mawer";
    String DOB3 = "02/01/2001";
    String sex3 = "Male";
    String numMRN3 = "234435";
    String location3 = "Imperial College London";

    Task t1;
    Patient pat3 = pat;
    String senior4 = "Junior Doctor";
    String notes4 = "family history of diabetes";
    String history4 = "previous task done: blood test and ECG";
    String taskDescript4 = "clinical review";
    String time4 = "13:24";

    Task t2;
    Patient pat5 = pat;
    String senior5 = "Junior Doctor";
    String notes5 = "family history of heart disease";
    String history5 = "";
    String taskDescript5 = "blood test review";
    String time5 = "ASAP";

    SingletonDatabase db = SingletonDatabase.getInstance();
    ArrayList<Task> tasks;

    // getInstance Test
    @Test
    public void testGetInstance(){
        // Test that the memory location of db is the same regardless of instance
        SingletonDatabase db1 = SingletonDatabase.getInstance();
        Assertions.assertEquals(db.hashCode(), db1.hashCode());
        SingletonDatabase db2 = SingletonDatabase.getInstance();
        Assertions.assertEquals(db.hashCode(), db2.hashCode());
    }
    // createPatient test
    @Test
    public void testCreatePatient(){
        db.reset();
        db.createPatient(name3,DOB3,sex3,location3,numMRN3);
        pat = db.getPatientList().get(0);
        Patient p = new Patient(name3, DOB3, sex3, location3, numMRN3);

        Assertions.assertEquals(pat.getNumMRN(), p.getNumMRN());
    }

    // createJrDoctor test
    @Test
    public void testCreateJrDoctor(){
        db.reset();
        db.createJrDoctor(name1, DOB1, sex1, email1, numPager1);
        d1 = db.getJrDoctorList().get(0);
        JuniorDoctor jr = new JuniorDoctor(name1, DOB1, sex1, email1, numPager1);

        Assertions.assertEquals(d1.getNumPager(), jr.getNumPager());
    }

    // createConsultant test
    @Test
    public void testCreateConsultant(){
        db.reset();
        db.createConsultant(name, DOB, sex, email, numPager);
        c = (Consultant) db.getHospitalPersonList().get(0);
        Consultant con = new Consultant(name, DOB, sex, email, numPager);

        Assertions.assertEquals(c.getNumPager(), con.getNumPager());
    }

    // createTask test
    @Test
    public void testCreateTask(){
        db.reset();
        Assertions.assertEquals(db.getCurrTaskList().size(), 0);
        db.createTask(pat3, senior4, notes4, history4, taskDescript4, time4);
        Assertions.assertEquals(1, db.getCurrTaskList().size());
        Task t = db.getCurrTaskList().get(0);
        Task todo = new Task(pat3, senior4, notes4, history4, taskDescript4, time4);

        Assertions.assertEquals(todo.getPatient(), t.getPatient());
    }

    // archiveTask test
    @Test
    public void testArchiveTask(){
        db.reset();
        db.createTask(pat3, senior4, notes4, history4, taskDescript4, time4);
        Task t = db.getCurrTaskList().get(0);
        Task todo = new Task(pat3, senior4, notes4, history4, taskDescript4, time4);

        Assertions.assertEquals(t.getPatient(), todo.getPatient());

        db.archiveTask(t);
        Assertions.assertEquals(db.getDoneTaskList().get(0).getPatient(), t.getPatient());
        Assertions.assertEquals(db.getCurrTaskList().size(), 0);
    }

    // createFollowUp test
    @Test
    public void testCreateFollowUp() {
        db.reset();
        db.createTask(pat3, senior4, notes4, history4, taskDescript4, time4);
        Task t = db.getCurrTaskList().get(0);
        String notesIn = notes5 + "\nAdditional Notes from Previous Task: \n" + notes4;
        Task todo = new Task(pat3, senior4, notesIn, history4, taskDescript5, time5);

        db.createFollowUp(t, senior4, notes5, taskDescript5, time5);

        Assertions.assertEquals(db.getCurrTaskList().size(), 1);
        Assertions.assertEquals(db.getDoneTaskList().size(), 1);

        Assertions.assertEquals(db.getCurrTaskList().get(0).getNotes(), todo.getNotes());
    }

//    @BeforeEach
    public void setUp(){
        db.reset();
        db.createConsultant(name, DOB, sex, email, numPager);
        c = (Consultant) db.getHospitalPersonList().get(0);

        db.createJrDoctor(name1, DOB1, sex1, email1, numPager1);
        d1 = db.getJrDoctorList().get(0);

        db.createJrDoctor(name2, DOB2, sex2, email2, numPager2);
        d2 = db.getJrDoctorList().get(1);

        db.createPatient(name3,DOB3,sex3,location3,numMRN3);
        pat = db.getPatientList().get(0);
        db.createTask(pat, senior4, notes4, history4, taskDescript4, time4);
        t1 = db.getCurrTaskList().get(0);
        db.createTask(pat5, senior5, notes5, history5, taskDescript5, time5);
        t2 = db.getCurrTaskList().get(1);

        tasks = new ArrayList<Task>();
        tasks.add(t1);
        tasks.add(t2);
    }

    // getCurrTaskList() Test
    @Test
    public void testGetCurrTaskList() {
        setUp();
        ArrayList<Task> dbTasks = db.getCurrTaskList();

        for (int i = 0; i < tasks.size(); i++) {
            Assertions.assertEquals(tasks.get(i), dbTasks.get(i));
        }
    }

    // getDoneTaskList() Test
    @Test
    public void testGetDoneTaskList() {
        setUp();
        db.archiveTask(t1);
        db.archiveTask(t2);
        ArrayList<Task> dbTasks = db.getDoneTaskList();

        for (int i = 0; i < dbTasks.size(); i++) {
            Assertions.assertEquals(tasks.get(i), dbTasks.get(i));
        }
    }

    // getPatientTasks(Patient P) test
    @Test
    public void testGetPatientTask(){
        setUp();
        Assertions.assertEquals(t1, db.getPatientTasks(pat).get(0));
    }

    // getDoctorTasks(Doctor doc) test
    @Test
    public void testGetDoctorTasks(){
        setUp();
        t1.setDoctorOfTask(d1);
        t2.setDoctorOfTask(d2);

        ArrayList<ArrayList<Task>> docTasks = db.getDoctorTasks();
        ArrayList<Task> doc1Tasks = db.getDoctorTasks(d1);

        Assertions.assertEquals(docTasks.size(), 2);
        Assertions.assertEquals(docTasks.get(0).get(0), t1);
        Assertions.assertEquals(docTasks.get(1).get(0), t2);

        Assertions.assertEquals(doc1Tasks.size(), 1);
        Assertions.assertEquals(doc1Tasks.get(0), t1);

        t2.setDoctorOfTask(d1);

        docTasks = db.getDoctorTasks();
        doc1Tasks = db.getDoctorTasks(d1);

        Assertions.assertEquals(docTasks.get(0).size(), 2);
        Assertions.assertEquals(doc1Tasks.size(), 2);
        Assertions.assertEquals(doc1Tasks.get(0), t1);
        Assertions.assertEquals(doc1Tasks.get(1), t2);
    }
}
