package com.example.nhs_handover_backend.Controllers;

import com.example.nhs_handover_backend.Services.JuniorDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JuniorDoctorController {
    private final JuniorDoctorService juniorDoctorService;

    @Autowired
    public JuniorDoctorController(JuniorDoctorService juniorDoctorService) {
        this.juniorDoctorService = juniorDoctorService;
    }
}
