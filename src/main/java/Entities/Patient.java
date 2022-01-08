package Entities;

public class Patient extends Person {
    private String patientLocation;
    private String numMRN;
    private String statusCOVID;

    public Patient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn, String statusCOVIDIn){
        super(nameIn,DOBIn,sexIn);
        patientLocation= patientLocationIn;
        numMRN=numMRNIn;
        statusCOVID = statusCOVIDIn;
    }

    public String getCOVIDStatus(){return statusCOVID;}

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
