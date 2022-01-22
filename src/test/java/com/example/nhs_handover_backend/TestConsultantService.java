////package com.example.nhs_handover_backend;
////import com.example.nhs_handover_backend.Repositories.ConsultantRepository;
////import com.example.nhs_handover_backend.Repositories.ConsultantRepositoryImplementer;
////import com.example.nhs_handover_backend.Repositories.PatientRepository;
////import com.example.nhs_handover_backend.Services.ConsultantService;
////import com.example.nhs_handover_backend.Services.ConsultantServiceImplementer;
////import com.example.nhs_handover_backend.Services.PatientService;
////import org.junit.jupiter.api.Test;
////import com.example.nhs_handover_backend.Entities.*;
////import com.example.nhs_handover_backend.Repositories.HospitalPersonnelRepository;
////import com.example.nhs_handover_backend.Services.HospitalPersonnelService;
////import org.junit.jupiter.api.Assertions;
////import org.junit.runner.RunWith;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
////import org.springframework.test.context.junit4.SpringRunner;
////
////import java.util.stream.Collectors;
////import java.util.stream.Stream;
////
////import static org.mockito.Mockito.when;
////
////@RunWith(SpringRunner.class)
////public class TestConsultantService {
////
////
////
////    @Autowired
////    private ConsultantRepositoryImplementer consultantRepositoryImplementer= new ConsultantRepositoryImplementer();
////
////    @Autowired
////    private ConsultantServiceImplementer consultantServiceImplementer = new ConsultantServiceImplementer(consultantRepositoryImplementer);
////
//////    @Test
//////    public void getAllConsultantsTest(){
//////        Consultant consultant = new Consultant("Nathan","DOB","Male","njm19@ic.ac.uk","0776589","abcd1234");
//////        consultantServiceImplementer.createConsultant(consultant);
//////        Assertions.assertEquals(1,consultantServiceImplementer.getAllConsultants().size());
//////    }
////
////
////    // need to make ceateConsultant return Consultant
////    @Test
////    public void createConsultantTest(){
////        Consultant consultant = new Consultant("Nathan","DOB","Male","L01","0776589","abcd1234");
////        consultantRepositoryImplementer.save(consultant);
////        Assertions.assertEquals(consultant,consultantServiceImplementer.createConsultant(consultant));
////    }
////}
//package com.example.nhs_handover_backend;
//import com.example.nhs_handover_backend.Repositories.ConsultantRepository;
//import com.example.nhs_handover_backend.Repositories.PatientRepository;
//import com.example.nhs_handover_backend.Services.ConsultantService;
//import com.example.nhs_handover_backend.Services.PatientService;
//import org.junit.jupiter.api.Test;
//import com.example.nhs_handover_backend.Entities.*;
//import com.example.nhs_handover_backend.Repositories.HospitalPersonnelRepository;
//import com.example.nhs_handover_backend.Services.HospitalPersonnelService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//public class TestConsultantService {
//
//
//    @InjectMocks
//    @Autowired
//    private ConsultantService consultantService;
//
//    @InjectMocks
//    @Autowired
//    private ConsultantRepository consultantRepository;
//
//    @Test
//    public void getAllConsultantsTest(){
//        Consultant consultant = new Consultant("Nathan","DOB","Male","njm19@ic.ac.uk","0776589","abcd1234");
//        consultantRepository.save(consultant);
//        Assertions.assertEquals(1,consultantService.getAllConsultants().size());
//    }
//
//
//    // need to make ceateConsultant return Consultant
//    @Test
//    public void createConsultantTest(){
//        Consultant consultant = new Consultant("Nathan","DOB","Male","L01","0776589","abcd1234");
//        consultantRepository.save(consultant);
//        Assertions.assertEquals(consultant,consultantService.createConsultant(consultant));
//    }
//}