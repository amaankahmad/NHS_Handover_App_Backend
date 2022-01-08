package Entities;

public class HospitalPersonnel extends Person {
    SingletonDatabase db = SingletonDatabase.getInstance();
    private String docName;
    private String email;
    private String numPager;
    private String nameIn;

    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        super(nameIn, DOBIn, sexIn);
        email = emailIn;
        numPager = numPagerIn;
    }

    public String getNumPager(){
        return  numPager;
    }

    public String getDrName(){
        docName = "Dr. " + getName();
        return docName;
    }

    public String getEmail(){
        return email;
    }

    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn, String statusCOVIDIn){
        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn, statusCOVIDIn);
    }

    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn, String urgencyIn){
        db.createTask(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn, urgencyIn);
    }
}
