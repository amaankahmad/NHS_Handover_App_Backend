package com.example.nhs_handover_backend;

import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Entities.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestHospitalPersonnel {

    String name1 = "Sacha Avey";
    String DOB1 = "07/03/2001";
    String sex1 = "Female";
    String email1 = "sa3019@ic.ac.uk";
    String numPager1 = "7502985";
    String password1 = "abcd1234";

    HospitalPersonnel hospPersonnel= new HospitalPersonnel("Sacha Avey","07/03/2001","Female","sa3019@ic.ac.uk","7502985","abcd1234", "Junior Doctor");

    Patient pat;
    String name2 = "Amaan Ahmad";
    String DOB2 = "27/01/2001";
    String sex2 = "Male";
    String numMRN2 = "123456";
    String patientLocation2 = "Imperial College London";

    Task t;
    Patient pat3 = pat;
    String senior3 = "consultant";
    String notes3 = "do task before 11 pm";
    String history3 = "past tasks done : ECG";
    String taskDescript3 = "Complete clinical review ";
    String time3 = "18:20";


    // Get Hospital Personnel Email() Test
    @Test
    public void testGetEmail() {
        Assertions.assertEquals(email1, hospPersonnel.getEmail());
    }

    // Get Hospital Personnel Pager Number Test
    @Test
    public void testGetNumPager() {
        Assertions.assertEquals(numPager1, hospPersonnel.getNumPager());
    }

    @Test
    public void testGetPassword(){
        Assertions.assertEquals(password1,hospPersonnel.getPassword());
    }

}