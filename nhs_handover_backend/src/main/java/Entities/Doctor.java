package Entities;

public abstract class Doctor extends HospitalPersonnel {
    private String nameIn;
    private String emailIn;
    private PatientDatabase dbIn;
    public Doctor(String nameIn, String DOBIn, String sexIn,String hospitalIDIn, String emailIn, String numPagerIn, PatientDatabase dbIn){
        super(nameIn, DOBIn, sexIn, hospitalIDIn, emailIn, numPagerIn, dbIn);
    }

    public abstract Task[] getTasks(String role);

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
