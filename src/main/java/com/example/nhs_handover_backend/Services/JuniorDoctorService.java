package com.example.nhs_handover_backend.Services;

import com.example.nhs_handover_backend.Entities.JuniorDoctor;
import com.example.nhs_handover_backend.Repositories.JuniorDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JuniorDoctorService {
    @Autowired
    private final JuniorDoctorRepository juniorDoctorRepository;
    @Autowired
    public JuniorDoctorService(JuniorDoctorRepository juniorDoctorRepository) {
        this.juniorDoctorRepository = juniorDoctorRepository;
    }

    public ArrayList<JuniorDoctor> getAllJuniorDoctors(){
        return (ArrayList<JuniorDoctor>) juniorDoctorRepository.findAll();
    }

    public void createJuniorDoctor(JuniorDoctor doc){
        juniorDoctorRepository.save(doc);
    }
}
