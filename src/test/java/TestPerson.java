import Entities.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPerson {
    Person p;
    String name1 = "Amaan Ahmad";
    String DOB1 = "27/01/2001";
    String sex1 = "Male";
   // Creates Entities.Person object in all tests
    @BeforeEach
    public void setUp(){
        p = new Person(name1,DOB1,sex1);
    }
    // getName() Test
    @Test
    public void testGetName(){
        Assertions.assertEquals(name1,p.getName());
    }
    // getDOB() test
    @Test
    public void testGetDOB(){
        Assertions.assertEquals(DOB1,p.getDOB());
    }
    // getSex test
    @Test
    public void testGetSex(){
        Assertions.assertEquals(sex1,p.getSex());
    }
}
