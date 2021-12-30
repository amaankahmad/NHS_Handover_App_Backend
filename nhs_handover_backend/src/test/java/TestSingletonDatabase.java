import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestSingletonDatabase {
    // Creates Entities.Person object in all tests
    Consultant c;
    String name1 = "Amaan Ahmad";
    String DOB1 = "27/01/2001";
    String sex1 = "Male";
    String ID1 = "123456";
    String email1 = "amaan@imperial.ac.uk";
    String numPager1 = "0234918321";

    JuniorDoctor d;
    String name2 = "Sacha Avey";
    String DOB2 = "01/01/2001";
    String sex2 = "Female";
    String ID2 = "3242542";
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
    HospitalPersonnel doctorOfTask1 = d;
    String senior4 = "Junior Doctor";
    String notes4 = "family history of diabetes";
    String history4 = "previous task done: blood test and ECG";
    String taskDescript4 = "clinical review";
    String time4 = "13:24";

    Task t2;
    Patient pat5 = pat;
    HospitalPersonnel doctorOfTask5 = d;
    String senior5 = "Junior Doctor";
    String notes5 = "family history of heart disease";
    String history5 = "";
    String taskDescript5 = "blood test review";
    String time5 = "ASAP";

    SingletonDatabase db = SingletonDatabase.getInstance();
    ArrayList<Task> tasks;

    @BeforeEach
    public void setUp(){
        db = SingletonDatabase.getInstance();
    }

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
        db.createPatient(name3, DOB3, sex3, location3, numMRN3);

        ArrayList<Patient> pList = new ArrayList<Patient>();
        Patient p = new Patient(name3, DOB3, sex3, location3, numMRN3);
        pList.add(p);

        Assertions.assertEquals(db.getPatientList().get(0).getNumMRN(), pList.get(0).getNumMRN());
    }
    // createHospitalPerson test
//    @Test
//    public void testCreateHospitalPerson(){
//        db.createHospitalPerson(name1, DOB1, sex1, location1, email1);
//
//        ArrayList<HospitalPersonnel> hList = new ArrayList<HospitalPersonnel>();
//        HospitalPersonnel p = new HospitalPersonnel(name1, DOB1, sex1, location1, ID1);
//        hList.add(p);
//
//        Assertions.assertEquals(db.getHospitalList().get(0).getEmail(), hList.get(0).getEmail());
//    }

    // getTasks() Test
    @Test
    public void testGetTasks() {
        ArrayList<Task> dbTasks = db.getCurrTaskList();

        for (int i = 0; i < tasks.size(); i++) {
            Assertions.assertEquals(tasks.get(i), dbTasks.get(i));
        }
    }

    // getCompletedTasks() Test
    @Test
    public void testGetCompletedTasks() {
        db.archiveTask(t1);
        db.archiveTask(t2);
        ArrayList<Task> dbTasks = db.getDoneTaskList();

        for (int i = 0; i < tasks.size(); i++) {
            Assertions.assertEquals(tasks.get(i), dbTasks.get(i));
        }
    }

    // getAllTasks() Test
    @Test
    public void testGetAllTasks() {
        db.archiveTask(t2);
        ArrayList<Task> dbTasks = db.getDoneTaskList();

        for (int i = 0; i < tasks.size(); i++) {
            Assertions.assertEquals(tasks.get(i), dbTasks.get(i));
        }
    }


    @Test
    public void testGetPatientTask(){
    }
}
