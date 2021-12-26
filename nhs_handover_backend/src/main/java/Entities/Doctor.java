package Entities;

public abstract class Doctor extends HospitalPersonnel {

    public Doctor(String nameIn, String DOBIn, String sexIn,String HospitalIDIn, String EmailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, HospitalIDIn, EmailIn, numPagerIn);
    }

    public abstract Task[] getTasks(String role);

    public String getName(){
        return nameIn;
    }

    public String getEmail() {return EmailIn;}

    public void updateTask(Task oldTask, Task newTask){

    }

    public void archiveTask(){

    }

}
