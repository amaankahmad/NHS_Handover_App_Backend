package Entities;

public class Consultant extends Doctor {
    public Consultant(String nameIn, String DOBIn, String sexIn,String HospitalIDIn, String EmailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, HospitalIDIn, EmailIn, numPagerIn);
    }

    public Task[] getTasks(String role){
       // Returns all tasks completed and not completed
        return null;
    }

    public Task[] getDoctorTasks(){
        //Returns all doctors current tasks
        return null;
    }

    public Task[] getDoctorTasks(Doctor doc) {
        //– if argument then returns tasks for specific doctor
        return null;
    }
}
