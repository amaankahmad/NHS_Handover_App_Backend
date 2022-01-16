package com.example.nhs_handover_backend.Repositories;

import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalPersonnelRepository extends CrudRepository<HospitalPersonnel, Long> {
}
