package com.example.nhs_handover_backend;

import com.example.nhs_handover_backend.Controllers.HospitalPersonnelController;
import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.Patient;
import com.example.nhs_handover_backend.Repositories.HospitalPersonnelRepository;
import com.example.nhs_handover_backend.Services.PatientService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestHospitalPersonnelController {


    private MockMvc mockMvc;

    @Mock
    private PatientService patientService;

    @InjectMocks
    private HospitalPersonnelController hospitalPersonnelController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(hospitalPersonnelController).build();
        HospitalPersonnel hospitalPersonnel = new HospitalPersonnel("Nathan", "DOB", "Male", "nmj@ic.ac.uk", "0776589","abcd1234");
        Patient patient = new Patient("Nathan", "DOB", "Male", "L01", "0776589");
    }

    @Test
    public void getAllHospitalPersonsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/v1/hospital_personnel/getAllHospitalPersons")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    public void getAllPatientsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/v1/hospital_personnel/getAllPatients")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    public void createHospitalPersonTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("api/v1/hospital_personnel/createHospitalPerson/{doc}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void createConsultantTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("api/v1/hospital_personnel/createConsultant")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    public void createJuniorDoctorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("api/v1/hospital_personnel/createJuniorDoctor")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void createFollowUpTaskTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/v1/hospital_personnel/createFollowUpTask/{oldTask}/{senior}/{notes}/{taskDescription}/{creationTime}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    public void getSeniorityTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/v1/hospital_personnel/getSeniority/{emailIn}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));

    }

    @Test
    public void archiveTaskTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/v1/hospital_personnel/archiveTask/{id}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));
    }
}