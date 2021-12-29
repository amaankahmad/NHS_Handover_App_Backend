package Entities;

public class HospitalPersonnel extends Person {
    private String email;
    private String numPager;
    private PatientDatabase db;

    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn, PatientDatabase dbIn){
        super(nameIn,DOBIn,sexIn);
        email=emailIn;
        numPager=numPagerIn;
        db = dbIn;
    }

    public String getNumPager(){
        return  numPager;
    }

    public String getEmail(){
        return email;
    }

    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn)
    }

    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        db.createTask(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
    }
}
