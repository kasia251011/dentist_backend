package com.dentistPlus.dentist_backend.controller;

import com.dentistPlus.dentist_backend.model.Appointment;
import com.dentistPlus.dentist_backend.service.AppointmentService;
import com.dentistPlus.dentist_backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        Appointment newAppointment = appointmentService.addAppointment(appointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.OK);
    }

    @GetMapping(params = "date")
    public ResponseEntity<List<Appointment>> getAllAppointments(@RequestParam("date")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDate(date);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping( path = "{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointment(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping(params = "patientId")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(@RequestParam("patientId") Long patientId) {
        List<Appointment> appointment = appointmentService.getAppointmentsByPatient(patientId);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @DeleteMapping( path = "{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

}
