package Entities;

public class Patient extends Person {
    private String patientLocation;
    private String numMRN;


    public Patient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
        super(nameIn,DOBIn,sexIn, numMRNIn);
        patientLocation= patientLocationIn;
        numMRN=numMRNIn;
    }

    public String getPatientLocation(){
        return patientLocation;
    }

    public void setPatientLocation(String patLoc){
        patientLocation=patLoc;
    }
}
