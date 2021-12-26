public class HospitalPersonnel extends Person{
    private String HospitalID;
    private String Email;
    private String numPager;

    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn,String HospitalIDIn, String EmailIn, String numPagerIn){
        super(nameIn,DOBIn,sexIn,new String[]{HospitalIDIn});
        HospitalID=HospitalIDIn;
        Email=EmailIn;
        numPager=numPagerIn;
    }

    public String getNumPager(){
        return  numPager;
    }

    public String getEmail(){
        return Email;
    }

    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn, String numNHSIn){
        Patient newPatient = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn, numNHSIn);
    }

    public void createTask(){
        //Adds task to task list by calling task model.
    }
}
