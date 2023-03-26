package com.dentistPlus.dentist_backend.service;

import com.dentistPlus.dentist_backend.model.Appointment;
import com.dentistPlus.dentist_backend.model.Patient;
import com.dentistPlus.dentist_backend.model.Procedure;
import com.dentistPlus.dentist_backend.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final AppointmentService appointmentService;
    private final ProcedureService procedureService;

    @Autowired
    public PatientService(
            PatientRepository patientRepository,
            AppointmentService appointmentService,
            ProcedureService procedureService
    ) {
        this.patientRepository = patientRepository;
        this.appointmentService = appointmentService;
        this.procedureService = procedureService;
    }

    public Patient addPatient(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    public List<Patient> getPatients() {
        return  (List<Patient>) patientRepository.findAll();
    }

    public Patient getPatient(Long id) {
        return  patientRepository.findById(id).orElseThrow(() -> new RuntimeException("No patient of this id found"));
    }

    public Patient deletePatient(Long patientId) {
        Patient patient = getPatient(patientId);
        patientRepository.delete(patient);
        return patient;
    }

    public Patient editPatient(Long id, Patient editedPatient) {
        Patient patient = getPatient(id);
        patient.setValues(editedPatient);
        patientRepository.save(patient);
        return  patient;
    }

    @Transactional
    public Patient addAppointmentToPatient(Long patientId, Appointment appointment, long procedureId) {
        Patient patient = getPatient(patientId);
        Procedure procedure = procedureService.getProcedure(procedureId);
        appointment.setProcedure(procedure);
        appointment.setPatient(patient);
        patient.addAppointment(appointment);

        return patient;
    }

    @Transactional
    public Patient deleteAppointmentFromPatient(Long patientId, Long appointmentId, Long procedureId) {
        Patient patient = getPatient(patientId);
        Appointment appointment = appointmentService.getAppointment(appointmentId);
        Procedure procedure = procedureService.getProcedure(procedureId);
        appointment.setProcedure(procedure);
        patient.deleteAppointment(appointment);

        return patient;
    }
}
