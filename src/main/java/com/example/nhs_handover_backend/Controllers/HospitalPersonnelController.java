package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Services.HospitalPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalPersonnelController {
    private final HospitalPersonnelService hospitalPersonnelService;

    @Autowired
    public HospitalPersonnelController(HospitalPersonnelService hospitalPersonnelService) {
        this.hospitalPersonnelService = hospitalPersonnelService;
    }
}
