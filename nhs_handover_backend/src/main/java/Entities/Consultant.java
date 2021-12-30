package Entities;

import java.util.ArrayList;

public class Consultant extends Doctor {
    SingletonDatabase db = SingletonDatabase.getInstance();

    public Consultant(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
    }

    public ArrayList<Task> getTasks(){
       // Returns all tasks not completed
        return db.getCurrTaskList();
    }

    public ArrayList<Task> getCompletedTasks(){
        // Returns all tasks completed
        return db.getDoneTaskList();
    }

    public ArrayList<Task> getAllTasks(){
        // Returns all tasks completed and not completed
        ArrayList<Task> todo = getTasks();
        ArrayList<Task> done = getCompletedTasks();
        todo.addAll(done);

        return todo;
    }

    public ArrayList<ArrayList<Task>> getDoctorTasks(){
        //Returns all doctors current tasks
        return db.getDoctorTasks();
    }

    public ArrayList<Task> getDoctorTasks(Doctor doc) {
        //– if argument then returns tasks for specific doctor
        return db.getDoctorTasks(doc);
    }
}
