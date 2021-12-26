import Entities.Doctor;
import Entities.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDoctor {
    Doctor doc;
    String name1 = "Peter James";
    String DOB1 = "20/08/1975";
    String sex1 = "Male";
    String HospitalID1 = "123456";
    String Email1= "peter.james@gmail.com";
    String numPager1= "123456";

    Patient pat;
    String name1 = "Amaan Ahmad";
    String DOB1 = "27/01/2001";
    String sex1 = "Male";
    String ID1 = "123456";
    String location1 = "Imperial College London";
    String location2 = "RSM";

    Task task1;
    String seniorityRequired1= "FY";
    String additionalNotes1= "Take blood and get results of creatinine level";
    String history1="";
    String time1="18:20";

    // Creates Entities.Doctor object in all tests
    @BeforeEach
    public void setUpDoctor(){
        doc = new Doctor(name1,DOB1,sex1,HospitalID1,Email1,numPager1);
    }
    // getName() Test
    @Test
    public void testGetName(){
        Assertions.assertEquals(name1,doc.getName());
    }
   // getEmail() test
    @Test
    public void testGetEmail(){ Assertions.assertEquals(Email1,doc.getEmail());}

    // Creates Entities.Patient and Entities.Task objects in following tests
    @BeforeEach
    public void setUp(){
        pat = new Patient(name1, DOB1, sex1, location1, ID1);
    }
    public void setUpTask(){
        task1 = new Task(pat,seniorityRequired1,additionalNotes1,history1,time1);
    }

    // getTime() Test
    @Test
    public void testGetTime(){
        Assertions.assertEquals(time1,task1.getTime());
    } //shall we do a testtask with that one?

}