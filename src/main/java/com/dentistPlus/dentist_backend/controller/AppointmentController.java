package com.dentistPlus.dentist_backend.controller;

import com.dentistPlus.dentist_backend.model.Appointment;
import com.dentistPlus.dentist_backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody final Appointment appointment) {
        Appointment newAppointment = appointmentService.addAppointment(appointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable final Long id) {
        Appointment appointment = appointmentService.getAppointment(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable final Long id) {
        Appointment appointment = appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable final Long id, @RequestBody final Appointment appointment) {
        Appointment editedAppointment =  appointmentService.editAppointment(id, appointment);
        return new ResponseEntity<>(editedAppointment, HttpStatus.OK);
    }
}
