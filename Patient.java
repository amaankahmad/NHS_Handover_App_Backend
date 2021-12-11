public class Patient extends Person{
    private String patientLocation;
    private String numMRN;
    private String numNHS;


    public Patient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn, String numNHSIn){
        super(nameIn,DOBIn,sexIn, new String[]{numMRNIn, numNHSIn});
        patientLocation= patientLocationIn;
        numMRN=numMRNIn;
        numNHS = numNHSIn;
    }

    public String getPatientLocation(){
        return patientLocation;
    }

    public void setPatientLocation(String patLoc){
        patientLocation=patLoc;
    }
}
