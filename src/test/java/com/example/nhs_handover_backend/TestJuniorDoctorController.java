package com.example.nhs_handover_backend;

import com.example.nhs_handover_backend.Controllers.HospitalPersonnelController;
import com.example.nhs_handover_backend.Controllers.JuniorDoctorController;
import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Services.PatientService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestJuniorDoctorController {


    private MockMvc mockMvc;

    @Mock
    private PatientService patientService;

    @InjectMocks
    private JuniorDoctorController juniorDoctorController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(juniorDoctorController).build();
         }

    @Test
    public void getAllHospitalPersonsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/v1/junior_doctor/takeUpTask")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    public void takeUpTaskTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/v1/junior_doctor/getAllPatients")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    public void getJuniorDoctorTasksTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("api/v1/hospital_personnel/getJuniorDoctorTasks")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));
    }
}