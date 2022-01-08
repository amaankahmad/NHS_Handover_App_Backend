import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestDoctor {

    JuniorDoctor jDoc;
    String name = "Peter James";
    String DOB = "20/08/1975";
    String sex = "Male";
    String email= "peter.james@gmail.com";
    String numPager= "123456";

    Patient pat;
    String name1 = "Amaan Ahmad";
    String DOB1 = "27/01/2001";
    String sex1 = "Male";
    String location1 = "Imperial College London";
    String numMRN1 = "123456";
    String statusCOVID1 = "Red";


    Task task1;
    Patient pat2=pat;
    String senior2= "FY";
    String notes2= "";
    String history2="";
    String taskDescript2 = "Check bloods";
    String time2="18:20";
    String urgency2 = "Low";



    Task task2;
    Patient pat3 = pat;
    String senior3 = "FY";
    String notes3 = "family history of diabetes";
    String history3 = "previous task done: blood test";
    String taskDescript3 = "clinical review";
    String time3 = "13:42";
    String urgency3 = "High";


    SingletonDatabase db = SingletonDatabase.getInstance();
    ArrayList<Task> tasks;

    @BeforeEach
    public void setUp() {
        db.reset();
        db.createJrDoctor(name, DOB, sex, email, numPager);
        jDoc = db.getJrDoctorList().get(0);

        db.createPatient(name1, DOB1, sex1, location1, numMRN1, statusCOVID1);
        pat = db.getPatientList().get(0);

        db.createTask(pat2, senior2, notes2, history2, taskDescript2, time2, urgency2);
        task1 = db.getCurrTaskList().get(0);

        db.createTask(pat3, senior3, notes3, history3, taskDescript3, time3, urgency3);
        task2 = db.getCurrTaskList().get(1);


        tasks = new ArrayList<Task>();
        tasks.add(task1);
        tasks.add(task2);

    }



    //    // getTasks() Test
    @Test
    public void testGetTasks(){
        ArrayList<Task> dbTasks = jDoc.getTasks();
        for (int i = 0; i < dbTasks.size(); i++) {
            Assertions.assertEquals(dbTasks.get(i), tasks.get(i));
        }
    }

     //updateTask() Test
    @Test
    public void testFollowUpTask(){
        jDoc.createFollowUpTask(task1,task2.getSeniorityRequired(), task2.getNotes(), task2.getTaskDescript(), task2.getTime(),task2.getUrgency());


        ArrayList<Task> dbTasks = db.getDoneTaskList();
        ArrayList<Task> dbCurrTasks = db.getCurrTaskList();
        Assertions.assertEquals(dbTasks.size(), 1); //task 1 is archived
        Assertions.assertEquals(dbCurrTasks.size(), 2);//the follow-up task is added

       //Verify components of the follow-up task correspond to our requirements
        Assertions.assertEquals(dbCurrTasks.get(0), task2);
        Assertions.assertEquals(dbCurrTasks.get(1).getPatient(), pat3);
        Assertions.assertEquals(dbCurrTasks.get(1).getTaskDescript(), taskDescript3);

        String notes4 = notes3 + "\nAdditional Notes from Previous Task: \n" + notes2;
        Assertions.assertEquals(dbCurrTasks.get(1).getNotes(), notes4);

        Assertions.assertEquals(dbCurrTasks.get(1).getSeniorityRequired(), senior3);
        Assertions.assertEquals(dbCurrTasks.get(1).getHistory(), history2);
        Assertions.assertEquals(dbCurrTasks.get(1).getTime(), time3);
    }
//
    // archiveTask() Test
    @Test
    public void testArchiveTask(){
    jDoc.archiveTask(task1);
    jDoc.archiveTask(task2);

    ArrayList<Task> dbTasks = db.getDoneTaskList();
        for (int i = 0; i < tasks.size(); i++) {
            Assertions.assertEquals(dbTasks.get(i), tasks.get(i));
        }
    }

}