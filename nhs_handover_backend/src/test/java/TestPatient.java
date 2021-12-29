import Entities.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPatient {
    Patient pat;
    String name1 = "Amaan Ahmad";
    String DOB1 = "27/01/2001";
    String sex1 = "Male";
    String ID1 = "123456";
    String location1 = "Imperial College London";
    String location2 = "RSM";

    // Creates Entities.Patient object in all tests
    @BeforeEach
    public void setUp(){
        pat = new Patient(name1, DOB1, sex1, location1, ID1);
    }
    // getID() test
    @Test
    public void testGetNumMRN(){
        Assertions.assertEquals(ID1, pat.getNumMRN());
    }
    // getPatientLocation() Test
    @Test
    public void testGetPatientLocation(){
        Assertions.assertEquals("Imperial College London",pat.getPatientLocation());
    }
    // setPatientLocation test
    @Test
    public void testSetPatientLocation(){
        pat.setPatientLocation(location2);
        Assertions.assertEquals("RSM",pat.getPatientLocation());
    }
}
