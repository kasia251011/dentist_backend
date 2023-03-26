package com.dentistPlus.dentist_backend.repository;

import com.dentistPlus.dentist_backend.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
