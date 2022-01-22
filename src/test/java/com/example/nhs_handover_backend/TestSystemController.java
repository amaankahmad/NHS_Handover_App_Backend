package com.example.nhs_handover_backend;

import com.example.nhs_handover_backend.Controllers.HospitalPersonnelController;
import com.example.nhs_handover_backend.Controllers.JuniorDoctorController;
import com.example.nhs_handover_backend.Controllers.SystemController;
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
public class TestSystemController {
    private MockMvc mockMvc;

    @InjectMocks
    private SystemController systemController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(systemController).build();
    }


    @Test
    public void sendMailTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("api/v1/system_controller/sendMail")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void archiveAllTasksTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("api/v1/system_controller/archiveAllTasks")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    public void removeAllTasksTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("api/v1/system_controller/removeAllTasks")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));
    }
}
