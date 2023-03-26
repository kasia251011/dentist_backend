package com.dentistPlus.dentist_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
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

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Appointment> appointments = new ArrayList<>();

    //TODO: Add photos, tooth and appointments

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
