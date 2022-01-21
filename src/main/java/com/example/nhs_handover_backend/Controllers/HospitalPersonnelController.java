package com.example.nhs_handover_backend.Controllers;
import com.example.nhs_handover_backend.Entities.*;
import com.example.nhs_handover_backend.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/hospital_personnel/")
public class HospitalPersonnelController {
    @Autowired
    private HospitalPersonnelService hospitalPersonnelService;
    @Autowired
    private final PatientService patientService;
    @Autowired
    private ConsultantService consultantService;
    @Autowired
    private JuniorDoctorService juniorDoctorService;

    @Autowired
    public HospitalPersonnelController(HospitalPersonnelService hospitalPersonnelService, PatientService patientService,
                                       ConsultantService consultantService, JuniorDoctorService juniorDoctorService) {
        this.hospitalPersonnelService = hospitalPersonnelService;
        this.patientService = patientService;
        this.consultantService = consultantService;
        this.juniorDoctorService = juniorDoctorService;
    }

    @GetMapping("/getAllHospitalPersons")
    public ArrayList<HospitalPersonnel> getAllHospitalPersons() {
        //return db.getHospitalPersonList();
        return hospitalPersonnelService.getAllHospitalPersons();
    }

    @GetMapping("/getAllPatients")
    public ArrayList<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    // Create hospital personnel
    @PostMapping("/createHospitalPerson")
    public void createHospitalPerson(@RequestBody HospitalPersonnel doc) {
        // Directly mapping the post json request body to the HospitalPersonnel object
        System.out.println(doc.getName());
        hospitalPersonnelService.createHospitalPersonnel(doc);
    }

    @PostMapping("/createConsultant")
    public void createConsultant(@RequestBody Consultant doc){
        consultantService.createConsultant(doc);
    }

    @PostMapping("/createJuniorDoctor")
    public void createJuniorDoctor(@RequestBody JuniorDoctor doc){
        juniorDoctorService.createJuniorDoctor(doc);
    }
}