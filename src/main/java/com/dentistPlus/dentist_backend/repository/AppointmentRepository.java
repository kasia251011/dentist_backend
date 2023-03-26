package com.dentistPlus.dentist_backend.repository;

import com.dentistPlus.dentist_backend.model.Appointment;
import com.dentistPlus.dentist_backend.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Optional<List<Appointment>> findAllByPatient(Patient patient);
    Optional<List<Appointment>> findAllByDate(LocalDate date);
}
