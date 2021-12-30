package Entities;

import java.util.ArrayList;

public abstract class Doctor extends HospitalPersonnel {
    private String nameIn;
    private String emailIn;
    private SingletonDatabase dbIn;
    public Doctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public abstract ArrayList<Task> getTasks();

    public String getName(){
        return nameIn;
    }

    public String getEmail() {return emailIn;} //already in hospital personel

    public void updateTask(Task oldTask, Task newTask){
        return;
    }

    public void archiveTask(Task taskDone){
        return;
    }

}
