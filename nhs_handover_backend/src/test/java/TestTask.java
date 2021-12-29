import Entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTask {
    Task newTask;
    Patient patientObjectIn = pat;
    String seniorityRequiredIn = "Consultant";
    String additionalNotesIn = "family history of diabetes";
    String historyIn = "previous task done: blood test and ECG";
    String creationTimeIn = "13:24";
    String taskDescriptionIn = "clinical review";

    Patient pat;
    String name2 = "Amaan Ahmad";
    String DOB2 = "27/01/2001";
    String sex2 = "Male";
    String ID1 = "123456";
    String location1 = "Imperial College London";

    // Creates Entities.Patient object in all tests
    @BeforeEach
    public void setUp(){
        newTask = new Task(patientObjectIn,seniorityRequiredIn,additionalNotesIn,historyIn,creationTimeIn,taskDescriptionIn);
    }
    // Get Task Time of Creation Test
    @Test
    public void testGetTaskTime(){
        Assertions.assertEquals("sa3019@ic.ac.uk",hospPersonnel.getEmail());
    }
    // Get Task Info Test
    @Test
    public void testGetTaskInfo(){
        Assertions.assertEquals("7502985",hospPersonnel.getNumPager());
    }

    // Get Task Patient Test
    @Test
    public void testGetTaskPatient(){
        Assertions.assertEquals("7502985",hospPersonnel.getNumPager());
    }

    public String getTime(){
        return creationTime;
    }

    public String[] getTaskInfo() {
        String[] res = {additionalNotes, history};
        return res;
    }

    public Patient getPatient() {
        return patientObject;
    }
}

}

