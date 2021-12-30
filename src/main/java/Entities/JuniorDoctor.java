package Entities;

import java.util.ArrayList;

public class JuniorDoctor extends Doctor {
    public JuniorDoctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public void takeUpTask(String task){
        //assigns task to themselves
        return;
    }

    public ArrayList<Task> getTasks(){
        //Returns all task available to junior doctor, by calling the task model
        return null;
    }
}
