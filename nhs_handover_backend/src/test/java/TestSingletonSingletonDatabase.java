import Entities.HospitalPersonnel;
import Entities.Patient;
import Entities.Person;
import Entities.SingletonDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestSingletonSingletonDatabase {
    // Creates Entities.Person object in all tests
    SingletonDatabase db;
    Patient pat;
    String name1 = "Amaan Ahmad";
    String DOB1 = "27/01/2001";
    String sex1 = "Male";
    String ID1 = "123456";
    String email1 = "a@imperial.com";
    String location1 = "Imperial College London";

    @BeforeEach
    public void setUp(){
        db = SingletonDatabase.getInstance();
    }

    // getInstance Test
    @Test
    public void testGetInstance(){
        // Test that the memory location of db is the same regardless of instance
        SingletonDatabase db1 = SingletonDatabase.getInstance();
        Assertions.assertEquals(db.hashCode(), db1.hashCode());
        SingletonDatabase db2 = SingletonDatabase.getInstance();
        Assertions.assertEquals(db.hashCode(), db2.hashCode());
    }
    // createPatient test
    @Test
    public void testCreatePatient(){
        db.createPatient(name1, DOB1, sex1, location1, ID1);

        ArrayList<Patient> pList = new ArrayList<Patient>();
        Patient p = new Patient(name1, DOB1, sex1, location1, ID1);
        pList.add(p);

        Assertions.assertEquals(db.getPatientList().get(0).getNumMRN(), pList.get(0).getNumMRN());
    }
    // createHospitalPerson test
    @Test
    public void testCreateHospitalPerson(){
        db.createHospitalPerson(name1, DOB1, sex1, location1, email1);

        ArrayList<HospitalPersonnel> hList = new ArrayList<HospitalPersonnel>();
        HospitalPersonnel p = new HospitalPersonnel(name1, DOB1, sex1, location1, ID1);
        hList.add(p);

        Assertions.assertEquals(db.getHospitalList().get(0).getEmail(), hList.get(0).getEmail());
    }

    @Test
    public void testGetPatientTask(){
    }
}
