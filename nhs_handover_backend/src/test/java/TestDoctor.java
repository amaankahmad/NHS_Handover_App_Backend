import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDoctor {
    SingletonDatabase hospitalDB = SingletonDatabase.getInstance();

    HospitalPersonnel doc;
    String name1 = "Peter James";
    String DOB1 = "20/08/1975";
    String sex1 = "Male";
    String Email1= "peter.james@gmail.com";
    String numPager1= "123456";

    Patient pat;
    String name2 = "Amaan Ahmad";
    String DOB2 = "27/01/2001";
    String sex2 = "Male";
    String ID1 = "123456";
    String location1 = "Imperial College London";

    Task task1;
    String seniorityRequired1= "FY";
    String additionalNotes1= "Take blood and get results of creatinine level";
    String history1="";
    String taskDescript1 = "Check bloods";
    String time1="18:20";

    Task task2;
    String seniorityRequired2= "FY";
    String additionalNotes2= " ";
    String history2="Check bloods";
    String taskDescript2 = "Take X-ray";
    String time2="19:20";

    // Creates Entities.Doctor object in all tests
    @BeforeEach
    public void setUpDoctor(){
        doc = new HospitalPersonnel(name1,DOB1,sex1,Email1,numPager1);
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
        pat = new Patient(name2, DOB2, sex2, location1, ID1);
    }
    public void setUpTask(){
        task1 = new Task(pat,seniorityRequired1,additionalNotes1, history1, taskDescript1,time1);
        task2 = new Task(pat,seniorityRequired2,additionalNotes2, history2, taskDescript2,time2);
    }

    // getTime() Test
    @Test
    public void testGetTime(){
        Assertions.assertEquals(time1,task1.getTime());
    } //shall we do a test task with that one?

    public void testGetTasks() {
//        Assertions.assertEquals(task1, doc.getTasks());
    }

    public void testUpdateTask(){
//        Assertions.assertEquals(task2, doc.updateTask());
    }

}