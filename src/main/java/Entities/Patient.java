package Entities;

public class Patient extends Person {
    private String patientLocation;
    private String numMRN;

    public Patient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
        super(nameIn,DOBIn,sexIn);
        patientLocation= patientLocationIn;
        numMRN=numMRNIn;
    }

    public String getNumMRN(){
        return numMRN;
    }

    public String getPatientLocation(){
        return patientLocation;
    }

    public void setPatientLocation(String patLoc){
        patientLocation=patLoc;
    }
}