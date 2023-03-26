package com.dentistPlus.dentist_backend.controller;

import com.dentistPlus.dentist_backend.model.Patient;
import com.dentistPlus.dentist_backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody final Patient patient) {
        Patient newPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable final Long id) {
        Patient patient = patientService.getPatient(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable final Long id) {
        Patient patient = patientService.deletePatient(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable final Long id, @RequestBody final Patient patient) {
        Patient editedPatient =  patientService.editPatient(id, patient);
        return new ResponseEntity<>(editedPatient, HttpStatus.OK);
    }
}
