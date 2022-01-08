package Entities;

import java.util.ArrayList;

public abstract class Doctor extends HospitalPersonnel {
    SingletonDatabase db = SingletonDatabase.getInstance();
    private String nameIn;
    private String emailIn;
    private SingletonDatabase dbIn;
    public Doctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public abstract ArrayList<Task> getTasks();

    public void createFollowUpTask(Task oldTask, String seniorIn, String notesIn, String taskDescriptIn, String creationTimeIn, String urgencyIn){
        db.createFollowUp(oldTask, seniorIn, notesIn, taskDescriptIn, creationTimeIn, urgencyIn);
    }

    public void archiveTask(Task taskDone){
        db.archiveTask(taskDone);
    }

}
