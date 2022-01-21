//package com.example.nhs_handover_backend;
//import com.example.nhs_handover_backend.Entities.JuniorDoctor;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestHospitalPersonnelController {
//    private MockMvc mockMvc;
//    @Autowired
//    private WebApplicationContext context;
//
//    ObjectMapper om = new ObjectMapper();
//
//    @Before
//    private void setUp(){
//        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Test
//    public void testAddJuniorDoctor() throws Exception {
//        JuniorDoctor doc = new JuniorDoctor("test","test","test","test","test");
//        String jsonRequest=om.writeValueAsString(doc);
//        MvcResult result = mockMvc.perform(post("api/v1/hospital_personnel/createJuniorDoctor").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE )).andExpect(status().isOk()).andReturn();
//        String resultContent = result.getResponse().getContentAsString();
//    }
//
//}
////package com.example.nhs_handover_backend;
////import org.junit.jupiter.api.Test;
////import com.example.nhs_handover_backend.Controllers.HospitalPersonnelController;
////import com.example.nhs_handover_backend.Entities.*;
////import com.example.nhs_handover_backend.Services.HospitalPersonnelService;
////import org.junit.runner.RunWith;
////import org.mockito.Mockito;
////import org.skyscreamer.jsonassert.JSONAssert;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
////import org.springframework.http.MediaType;
////import org.springframework.test.context.junit4.SpringRunner;
////import org.springframework.test.web.servlet.MockMvc;
////import org.springframework.test.web.servlet.MvcResult;
////import org.springframework.test.web.servlet.RequestBuilder;
////import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
////import org.springframework.web.bind.annotation.*;
////import java.util.*;
////import java.util.ArrayList;
////import com.example.nhs_handover_backend.Services.*;
////import com.example.nhs_handover_backend.Repositories.*;
////import static org.junit.jupiter.api.Assertions.assertEquals;
////import static org.springframework.data.repository.init.ResourceReader.Type.JSON;
//
////@RunWith(SpringRunner.class)
////@WebMvcTest(value = HospitalPersonnelController.class)
////public class TestHospitalPersonnelController {
////    @Autowired
////    private MockMvc mockMvc;
////
////    @MockBean
////    private HospitalPersonnelService hospitalPersonnelService;
////
////    String name1 = "Sacha Avey";
////    String DOB1 = "07/03/2001";
////    String sex1 = "Female";
////    String email1 = "sa3019@ic.ac.uk";
////    String numPager1 = "7502985";
////
////    ArrayList<HospitalPersonnel> L2 = new ArrayList<>();
////    HospitalPersonnel h = new HospitalPersonnel(name1,DOB1,sex1,email1,numPager1);
////
////    @Test
////    public void getAllHospitalPersonnel() throws Exception {
////        L2.add(h);
////        Mockito.when(hospitalPersonnelService.getAllHospitalPersons()).thenReturn(L2);
////        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("api/v1/hospital_personnel/getAllHospitalPersons").accept(MediaType.APPLICATION_JSON);
////
////        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////
////        System.out.println(result.getResponse());
////        String expected = "[{name:Sacha Avey,sex:Female,email:sa301@ic.ac.uk,numpager:7502985,dob:7th march}]";
////        assertEquals(expected, result.getResponse().getContentAsString());
////    }
////}
