import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPatient {
    Patient pat;
    // Creates Patient object in all tests
    @BeforeEach
    Public void setUp(){
        pat = new Patient("Location");
    }
    // getPatientLocation() Test
    @Test
    Public void testGetPatientLocation(){
        Assertions.assertEquals("Location",pat.getLocation());
    }
    // setPatientLocation test
    @Test
    Public void testSetPatientLocation(){
        string loc = pat.setPatientLocation("LocNew")
        Assertions.assertEquals("LocNew",pat.getPatientLocation());
    }
}
