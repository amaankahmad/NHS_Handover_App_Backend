package com.example.nhs_handover_backend.Services;


import com.example.nhs_handover_backend.Entities.Consultant;
import com.example.nhs_handover_backend.Repositories.ConsultantRepository;
import com.example.nhs_handover_backend.Repositories.ConsultantRepositoryImplementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("api/v1/test/")
@Controller
public class ConsultantServiceImplementer {
    @Autowired
    private ConsultantRepositoryImplementer consultantRepositoryImplementer;

    @Autowired
    public ConsultantServiceImplementer(ConsultantRepositoryImplementer consultantRepositoryImplementer) {
        this.consultantRepositoryImplementer = consultantRepositoryImplementer;
    }

    public Consultant createConsultant(Consultant doc){
        consultantRepositoryImplementer.save(doc);
        return doc;
    }

    @RequestMapping("/test")
    public Consultant createConsultant(){
        Consultant doc = new Consultant("test","test","test","test","test","test");
        consultantRepositoryImplementer.save(doc);
        return doc;
    }

    public ArrayList<Consultant> getAllConsultants() {
        return (ArrayList<Consultant>) consultantRepositoryImplementer.findAll();
    }
}