package Entities;

import java.util.ArrayList;

public class JuniorDoctor extends Doctor {

    SingletonDatabase db = SingletonDatabase.getInstance();

    public JuniorDoctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public ArrayList<Task> takeUpTask(Doctor doc){
        //assigns task to themselves
        return db.getDoctorTasks(doc);
    }

    public ArrayList<Task> getTasks(){
        //Returns all task available to junior doctor, by calling the task model
        return db.getCurrTaskList();
    }
}