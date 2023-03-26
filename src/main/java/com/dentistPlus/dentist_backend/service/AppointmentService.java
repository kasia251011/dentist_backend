package com.dentistPlus.dentist_backend.service;

import com.dentistPlus.dentist_backend.model.Appointment;
import com.dentistPlus.dentist_backend.model.Patient;
import com.dentistPlus.dentist_backend.repository.AppointmentRepository;
import com.dentistPlus.dentist_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AppointmentService(
            AppointmentRepository appointmentRepository,
            PatientRepository patientRepository
    ) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    public Appointment addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return appointment;
    }

    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        Optional<List<Appointment>> appointmentsByDate = appointmentRepository.findAllByDate(date);
        List<Appointment> appointments = appointmentsByDate.orElseThrow(() -> new RuntimeException("err"));
        return  appointments;
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        Optional<Patient> patientById = patientRepository.findById(patientId);

        Patient patient = patientById.orElseThrow(() -> new RuntimeException("err"));
        Optional<List<Appointment>> appointmentsByPatient=  appointmentRepository.findAllByPatient(patient);

        List<Appointment> appointments = appointmentsByPatient.orElseThrow(() -> new RuntimeException("err"));

        return  appointments;
    }


    public Appointment getAppointment(Long id) {
        return  appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("No appointment of this id found"));
    }

    public Appointment deleteAppointment(Long appointmentId) {
        Appointment appointment = getAppointment(appointmentId);
        appointmentRepository.delete(appointment);
        return appointment;
    }

    public Appointment editAppointment(Long id, Appointment editedAppointment) {
        Appointment appointment = getAppointment(id);
        appointment.setValues(editedAppointment);
        appointmentRepository.save(appointment);
        return  appointment;
    }
}
