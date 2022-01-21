package com.example.nhs_handover_backend;
import com.example.nhs_handover_backend.Repositories.HospitalPersonnelRepositoryImplementer;
import org.junit.jupiter.api.Test;
import com.example.nhs_handover_backend.Entities.*;
import com.example.nhs_handover_backend.Repositories.HospitalPersonnelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TestHospitalPersonnelService {

    @MockBean
    private HospitalPersonnelRepositoryImplementer hospitalPersonnelRepositoryImplementer = new HospitalPersonnelRepositoryImplementer();


    @Test
    public void getAllHospitalPersonsTest(){
        when(hospitalPersonnelRepositoryImplementer.findAll()).thenReturn(Stream.of( new HospitalPersonnel("Nathan","DOB","Male","nmj@ic.ac.uk","0776589")).collect(Collectors.toList()));
        ArrayList<HospitalPersonnel> hospitalPersonnelArrayList = (ArrayList<HospitalPersonnel>) hospitalPersonnelRepositoryImplementer.findAll();
        Assertions.assertEquals(1,hospitalPersonnelArrayList.size());
    }


}