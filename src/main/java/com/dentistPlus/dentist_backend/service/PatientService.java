package com.dentistPlus.dentist_backend.service;

import com.dentistPlus.dentist_backend.model.Patient;
import com.dentistPlus.dentist_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
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
}
