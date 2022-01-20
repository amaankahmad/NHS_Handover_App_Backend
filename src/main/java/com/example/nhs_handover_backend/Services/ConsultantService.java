package com.example.nhs_handover_backend.Services;


import com.example.nhs_handover_backend.Entities.Consultant;
import com.example.nhs_handover_backend.Repositories.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConsultantService {
    @Autowired
    private ConsultantRepository consultantRepository;

    @Autowired
    public ConsultantService(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    public void createConsultant(Consultant doc){
        consultantRepository.save(doc);
    }

    public ArrayList<Consultant> getAllConsultants() {
        return (ArrayList<Consultant>) consultantRepository.findAll();
    }
}
