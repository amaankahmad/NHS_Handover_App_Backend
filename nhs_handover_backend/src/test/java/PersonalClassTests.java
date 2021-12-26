import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPerson {
    Person p;
   // Creates Person object in all tests
    @BeforeEach
    Public void setUp(){
        p = new Person("Name","DOB","Sex","ID");
    }
    // getName() Test
    @Test
    Public void testGetName(){
        Assertions.assertEquals("Name",p.getName());
    }
    // getDOB() test
    @Test
    Public void testGetDOB(){
        Assertions.assertEquals("DOB",p.getDOB());
    }
    // getID() test
    @Test
    Public void testGetID(){
        Assertions.assertEquals("ID",p.getID());
    }
    // getSex test
    @Test
    Public void testGetSex(){
        Assertions.assertEquals("Sex",p.getSex());
    }
}
