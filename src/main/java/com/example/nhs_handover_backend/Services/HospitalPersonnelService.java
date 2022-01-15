package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Repositories.HospitalPersonnelRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalPersonnelService {

    private final HospitalPersonnelRepository hospitalPersonnelRepository;

    public HospitalPersonnelService(HospitalPersonnelRepository hospitalPersonnelRepository) {
        this.hospitalPersonnelRepository = hospitalPersonnelRepository;
    }

    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
//        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);

    }
}
