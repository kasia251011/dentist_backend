package com.dentistPlus.dentist_backend.service;

import com.dentistPlus.dentist_backend.model.Appointment;
import com.dentistPlus.dentist_backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return appointment;
    }

    public List<Appointment> getAppointments() {
        return  (List<Appointment>) appointmentRepository.findAll();
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
