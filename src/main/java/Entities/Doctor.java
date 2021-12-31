package Entities;

import java.util.ArrayList;

public abstract class Doctor extends HospitalPersonnel {
    SingletonDatabase db = SingletonDatabase.getInstance();
    public Doctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public abstract ArrayList<Task> getTasks();

    public void followUpTask(Task oldTask, Task newTask){
        db.createFollowUp(oldTask,newTask.getSeniorityRequired(),newTask.getNotes(),newTask.getTaskDescript(),newTask.getTime());
    }

    public void archiveTask(Task taskDone){
         db.archiveTask(taskDone);
    }

}
