package com.dentistPlus.dentist_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "procedure_id")
    private Procedure procedure;
    private LocalTime time;
    private LocalDate date;

    public Appointment() {
    }

    public void setValues(Appointment appointment) {
        this.setPatient(appointment.getPatient());
        this.setProcedure(appointment.getProcedure());
        this.setTime(appointment.getTime());
        this.setDate(appointment.getDate());
    }
}
