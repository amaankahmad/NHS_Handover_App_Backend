import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTask {

    PatientDatabase hospitalDB = new PatientDatabase();

    HospitalPersonnel doc;
    String name1 = "Peter James";
    String DOB1 = "20/08/1975";
    String sex1 = "Male";
    String email1= "peter.james@gmail.com";
    String numPager1= "123456";
    PatientDatabase db1 = hospitalDB;


    Patient pat;
    String name2 = "Amaan Ahmad";
    String DOB2 = "27/01/2001";
    String sex2 = "Male";
    String numMRN2 = "123456";
    String location2 = "Imperial College London";

    Task t;
    Patient pat3 = pat;
    HospitalPersonnel doctorOfTask1 = doc;
    String senior3 = "Consultant";
    String notes3 = "family history of diabetes";
    String history3 = "previous task done: blood test and ECG";
    String time3 = "13:24";
    String taskDescript3 = "clinical review";


    @BeforeEach
    public void setUp(){
        doc = new HospitalPersonnel(name1,DOB1,sex1,email1,numPager1,db1);
        pat=new Patient(name2,DOB2,sex2,location2,numMRN2);
        t = new Task(pat3, senior3, notes3, history3, taskDescript3, time3);
         }
    setDoctorOfTask
    // Set Doctor of Task Test
    @Test
    public void testSetDoctorOfTask(){
        t.setDoctorOfTask(doc);
        Assertions.assertEquals(doc,t.getDoctorOfTask());
    }
    public void testGetDoctorOfTask(){
        t.setDoctorOfTask(doc);
        Assertions.assertEquals(doc,t.getDoctorOfTask());
    }

    // Get Task Time of Creation Test
    @Test
    public void testGetTime(){
        Assertions.assertEquals("13:24",t.getTime());
    }

    // Get Task Info Test
    @Test
    public void testGetTaskInfo(){
        String[] res={notes3, history3};
        Assertions.assertEquals(res,t.getTaskInfo());
    }

    // Get Task Patient Test
    @Test
    public void testGetPatient(){
        Assertions.assertEquals(pat,t.getPatient());
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

