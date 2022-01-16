package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Repositories.HospitalPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalPersonnelService {
    private final HospitalPersonnelRepository hospitalPersonnelRepository;

    @Autowired
    public HospitalPersonnelService(HospitalPersonnelRepository hospitalPersonnelRepository) {
        this.hospitalPersonnelRepository = hospitalPersonnelRepository;
    }
}
