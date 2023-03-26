package com.dentistPlus.dentist_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String avatar;
    private String name;
    private String surname;
    private String pesel;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;

    public Patient() {
    }

    public void setValues(Patient newPatient)
    {
        this.setName(newPatient.getName());
        this.setSurname(newPatient.getSurname());
        this.setPesel(newPatient.getPesel());
        this.setPhoneNumber(newPatient.getPhoneNumber());
        this.setDateOfBirth(newPatient.getDateOfBirth());
    }
}
