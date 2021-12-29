import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestHospitalPersonnel {

    PatientDatabase hospitalDB;

    HospitalPersonnel hospPersonnel;
    String name1 = "Sacha Avey";
    String DOB1 = "07/03/2001";
    String sex1 = "Female";
    String email1 = "sa3019@ic.ac.uk";
    String numPager1 = "7502985";
    PatientDatabase db1 = hospitalDB;

    Patient pat;
    String name2 = "Amaan Ahmad";
    String DOB2 = "27/01/2001";
    String sex2 = "Male";
    String numMRN2 = "123456";
    String patientLocation2 = "Imperial College London";

    Task t;
    Patient pat3= pat;
    String senior3= "consultant";
    String notes3 = "do task before 11 pm";
    String history3 = "past tasks done : ECG";
    String taskDescript3 = "Complete clinical review ";
    String time3="18:20";




    // Creates Entities.HospitalPersonnel object in all tests (nameIn, DOBIn, sexIn, hospitalIDIn, emailIn, numPagerIn)
    @BeforeEach
    public void setUp(){
        hospitalDB = new PatientDatabase();
        hospPersonnel = new HospitalPersonnel(name1,DOB1,sex1,email1,numPager1,db1);
        pat=new Patient(name2,DOB2,sex2,patientLocation2,numMRN2);
        t = new Task(pat3, senior3, notes3, history3, taskDescript3, time3);

    }
    // Get Hospital Personnel Email() Test
    @Test
    public void testGetHospitalPersonnelEmail(){
        Assertions.assertEquals("sa3019@ic.ac.uk",hospPersonnel.getEmail());
    }

    // Get Hospital Personnel Pager Number Test
    @Test
    public void testGetHospitalPersonnelPagerNum(){
        Assertions.assertEquals("7502985",hospPersonnel.getNumPager());
    }

   //hospital personnel add patient test
    @Test
    public void testHospitalPersonnelAddPatient(){
        ArrayList<Patient> pList = new ArrayList<Patient>();
        pList.add(pat);
        hospPersonnel.addPatient(name2,DOB2,sex2,patientLocation2,numMRN2);
        Assertions.assertEquals(db.getPatientList().get(0).getNumMRN(), pList.get(0).getNumMRN());
    }

    //hospital personnel create task test
    @Test
    public void testHospitalPersonnelCreateTask() {

        ArrayList<Task> tList = new ArrayList<Task>();
        tList.add(t);
        hospPersonnel.createTask(pat3, senior3, notes3, history3, taskDescript3, time3);
        Assertions.assertEquals(db.getPatientTask(pat3).get(0), tList.get(0));
    };