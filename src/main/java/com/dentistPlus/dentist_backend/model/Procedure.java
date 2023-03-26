package com.dentistPlus.dentist_backend.model;

import com.dentistPlus.dentist_backend.repository.ProcedureRepository;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "procedure")
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer price;
    private Integer duration;

    public Procedure() {
    }

    public void setValues(Procedure procedure) {
        this.setName(procedure.getName());
        this.setPrice(procedure.getPrice());
        this.setDuration(procedure.getDuration());
    }
}