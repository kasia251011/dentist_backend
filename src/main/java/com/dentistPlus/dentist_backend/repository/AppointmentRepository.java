package com.dentistPlus.dentist_backend.repository;

import com.dentistPlus.dentist_backend.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
