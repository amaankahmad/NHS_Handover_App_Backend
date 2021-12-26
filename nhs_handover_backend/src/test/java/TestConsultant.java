import Entities.Consultant;
import Entities.Doctor;
import Entities.JuniorDoctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestConsultant {
    Consultant c;
    String name1 = "Amaan Ahmad";
    String DOB1 = "27/01/2001";
    String sex1 = "Male";
    String ID1 = "123456";
    String email1 = "amaan@imperial.ac.uk";
    String numPager1 = "0234918321";

    JuniorDoctor d;
    String name2 = "Sacha Avey";
    String DOB2 = "01/01/2001";
    String sex2 = "Female";
    String ID2 = "3242542";
    String email2 = "sacha@imperial.ac.uk";
    String numPager2 = "4532464536";
    // Creates Entities.Person object in all tests
    @BeforeEach
    public void setUp() {
        c = new Consultant(name1, DOB1, sex1, ID1, email1, numPager1);
        d = new JuniorDoctor(name2, DOB2, sex2, ID2, email2, numPager2);
    }
    // getTasks() Test
    @Test
    public void testGetTasks() {
        Assertions.assertEquals(sex1, c.getSex());
    }

    // getDoctorTasks() Test
    @Test
    public void testGetDoctorTasks(){
        Assertions.assertEquals(sex1, c.getSex());
    }

    // getDoctorTasks(Doctor doc) Test
    @Test
    public void testGetDoctorTasks(Doctor d){
        Assertions.assertEquals(sex1,d.getSex());
    }
}
