import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestConsultant {
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

    // Creates Entities.Person object in all tests
    @BeforeEach
    public void setUp() {
        db.reset();
        db.createConsultant(name, DOB, sex, email, numPager);
        c = (Consultant) db.getHospitalPersonList().get(0);

        db.createJrDoctor(name1, DOB1, sex1, email1, numPager1);
        d1 = db.getJrDoctorList().get(0);

        db.createJrDoctor(name2, DOB2, sex2, email2, numPager2);
        d2 = db.getJrDoctorList().get(1);

        db.createPatient(name3, DOB3, sex3, location3, numMRN3);
        pat = db.getPatientList().get(0);
        db.createTask(pat3, senior4, notes4, history4, taskDescript4, time4);
        t1 = db.getCurrTaskList().get(0);
        db.createTask(pat5, senior5, notes5, history5, taskDescript5, time5);
        t2 = db.getCurrTaskList().get(1);

        tasks = new ArrayList<Task>();
        tasks.add(t1);
        tasks.add(t2);
    }

    // getTasks() Test
    @Test
    public void testGetTasks() {
        ArrayList<Task> dbTasks = c.getTasks();

        for (int i = 0; i < dbTasks.size(); i++) {
            Assertions.assertEquals(dbTasks.get(i), tasks.get(i));
        }
    }

    // getCompletedTasks() Test
    @Test
    public void testGetCompletedTasks() {
        db.archiveTask(t1);
        db.archiveTask(t2);
        ArrayList<Task> dbTasks = c.getCompletedTasks();

        for (int i = 0; i < tasks.size(); i++) {
            Assertions.assertEquals(dbTasks.get(i), tasks.get(i));
        }
    }

    // getAllTasks() Test
    @Test
    public void testGetAllTasks() {
        db.archiveTask(t2);
        ArrayList<Task> dbTasks = c.getAllTasks();

        for (int i = 0; i < dbTasks.size(); i++) {
            Assertions.assertEquals(tasks.get(i), dbTasks.get(i));
        }
    }

    // getDoctorTasks() Test
    @Test
    public void testGetDoctorTasks() {
        t1.setDoctorOfTask(d1);
        t2.setDoctorOfTask(d2);

        ArrayList<ArrayList<Task>> docTasks = c.getDoctorTasks();
        ArrayList<Task> doc1Tasks = c.getDoctorTasks(d1);

        Assertions.assertEquals(docTasks.size(), 2);
        Assertions.assertEquals(docTasks.get(0).get(0), t1);
        Assertions.assertEquals(docTasks.get(1).get(0), t2);

        Assertions.assertEquals(doc1Tasks.size(), 1);
        Assertions.assertEquals(doc1Tasks.get(0), t1);

        t2.setDoctorOfTask(d1);

        docTasks = c.getDoctorTasks();
        doc1Tasks = c.getDoctorTasks(d1);

        Assertions.assertEquals(docTasks.get(0).size(), 2);
        Assertions.assertEquals(doc1Tasks.size(), 2);
        Assertions.assertEquals(doc1Tasks.get(0), t1);
        Assertions.assertEquals(doc1Tasks.get(1), t2);
    }
}
