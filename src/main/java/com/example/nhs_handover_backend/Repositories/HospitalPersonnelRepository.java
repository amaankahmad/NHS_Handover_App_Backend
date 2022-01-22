package com.example.nhs_handover_backend.Repositories;

import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HospitalPersonnelRepository extends CrudRepository<HospitalPersonnel, Long> {
    public ArrayList<HospitalPersonnel> findByEmail(String email);
}
