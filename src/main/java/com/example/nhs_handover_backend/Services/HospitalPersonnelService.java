package com.example.nhs_handover_backend.Services;
import com.example.nhs_handover_backend.Entities.*;
import com.example.nhs_handover_backend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HospitalPersonnelService {
    @Autowired
    private HospitalPersonnelRepository hospitalPersonnelRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    public HospitalPersonnelService(HospitalPersonnelRepository hospitalPersonnelRepository) {
        this.hospitalPersonnelRepository = hospitalPersonnelRepository;
    }

    public ArrayList<HospitalPersonnel> getAllHospitalPersons(){
        ArrayList<HospitalPersonnel> arrayList = new ArrayList<>();
        hospitalPersonnelRepository.findAll().forEach(arrayList::add);
        return arrayList;
    }

//    public void addPatient(Patient pat) {
//        patientRepository.save(pat);
//    }



    public void createHospitalPersonnel(HospitalPersonnel hospitalPersonnel) {
        hospitalPersonnelRepository.save(hospitalPersonnel);
    }
}