import Entities.HospitalPersonnel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestHospitalPersonnel {
    String nameIn = "Sacha Avey";
    String DOBIn = "07/03/2001";
    String sexIn = "Female";
    String hospitalIDIn = "01735295";
    String emailIn = "sa3019@ic.ac.uk";
    String numPagerIn = "7502985";

    // Creates Entities.Patient object in all tests
    @BeforeEach
    public void setUp(){
        hospPersonnel = new HospitalPersonnel(nameIn, DOBIn, sexIn, hospitalIDIn, emailIn, numPagerIn);
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