package Entities;

public class HospitalPersonnel extends Person {
    private String email;
    private String numPager;
    private SingletonDatabase db;

    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        super(nameIn, DOBIn, sexIn);
        email = emailIn;
        numPager = numPagerIn;
    }

    public String getNumPager(){
        return  numPager;
    }

    public String getEmail(){
        return email;
    }

    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
        Patient newPatient = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
    }

    public void createTask(){
        //Adds task to task list by calling task model.
        return ;
    }
}
