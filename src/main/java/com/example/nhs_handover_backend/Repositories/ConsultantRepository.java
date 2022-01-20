package com.example.nhs_handover_backend.Repositories;

import com.example.nhs_handover_backend.Entities.Consultant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends CrudRepository<Consultant, Long> {
}
