import Entities.HospitalPersonnel;
import Entities.PatientDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestHospitalPersonnel {

    PatientDatabase hospitalDB = new PatientDatabase();

    HospitalPersonnel hospPersonnel;
    String nameIn = "Sacha Avey";
    String DOBIn = "07/03/2001";
    String sexIn = "Female";
    String emailIn = "sa3019@ic.ac.uk";
    String numPagerIn = "7502985";
    PatientDatabase dbIn = hospitalDB;

    // Creates Entities.HospitalPersonnel object in all tests (nameIn, DOBIn, sexIn, hospitalIDIn, emailIn, numPagerIn)
    @BeforeEach
    public void setUp(){
        hospPersonnel = new HospitalPersonnel(nameIn,DOBIn,sexIn,emailIn,numPagerIn,dbIn);
    }
    // Get Hospital Personnel Email() Test
    @Test
    public void testGetHospitalPersonnelEmail(){
        Assertions.assertEquals("sa3019@ic.ac.uk",hospPersonnel.getEmail());
    }
    // Get Hospital Personnel Pager Number Test
    @Test
    public void testGetHospitalPersonnelPagerNum(){
        Assertions.assertEquals("7502985",hospPersonnel.getNumPager());
    }
}
//      need to do tests for following methods:
//    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
//        Patient newPatient = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
//    }
//
//    public void createTask(){
//        //Adds task to task list by calling task model.
//        return ;
//    }