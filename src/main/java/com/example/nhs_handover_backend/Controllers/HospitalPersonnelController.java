package com.example.nhs_handover_backend.Controllers;
import com.example.nhs_handover_backend.Entities.*;
import com.example.nhs_handover_backend.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

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
        System.out.println(hospitalPersonnelService.getAllHospitalPersons().get(0).getRole());
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

   //Make patient with individual parameters instead of patient object
    @RequestMapping(path="/addPatient/{name}/{dob}/{sex}/{loc}/{mrn}", method = RequestMethod.GET)
    public void addPatient(@PathVariable("name") String nameIn,@PathVariable("dob") String DOBIn,@PathVariable("sex") String sexIn,@PathVariable("loc") String locationIn,@PathVariable("mrn") String numMRNIn){
          Patient p = new Patient(nameIn,DOBIn,sexIn,locationIn,numMRNIn);
        patientService.addPatient(p);
    }

    @RequestMapping(path="/addPatient/{pat}", method = RequestMethod.GET)
    public void addPatient(@PathVariable("pat") Patient patIn){
        patientService.addPatient(patIn);
    }
}