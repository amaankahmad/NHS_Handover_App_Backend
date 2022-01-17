package com.example.nhs_handover_backend.Repositories;

import com.example.nhs_handover_backend.Entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
