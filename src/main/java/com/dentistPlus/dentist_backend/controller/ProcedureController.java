package com.dentistPlus.dentist_backend.controller;

import com.dentistPlus.dentist_backend.model.Procedure;
import com.dentistPlus.dentist_backend.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedures")
public class ProcedureController {

    private final ProcedureService procedureService;

    @Autowired
    public ProcedureController(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    @PostMapping
    public ResponseEntity<Procedure> addProcedure(@RequestBody Procedure procedure) {
        Procedure newProcedure = procedureService.addProcedure(procedure);
        return new ResponseEntity<>(newProcedure, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Procedure>> getAllProcedures() {
        List<Procedure> procedures = procedureService.getProcedures();
        return new ResponseEntity<>(procedures, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Procedure> getProcedure(@PathVariable Long id) {
        Procedure procedure = procedureService.getProcedure(id);
        return new ResponseEntity<>(procedure, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Procedure> deleteProcedure(@PathVariable Long id) {
        Procedure procedure = procedureService.deleteProcedure(id);
        return new ResponseEntity<>(procedure, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Procedure> getProcedure(@PathVariable Long id, @RequestBody Procedure procedure) {
        Procedure editedProcedure =  procedureService.editProcedure(id, procedure);
        return new ResponseEntity<>(editedProcedure, HttpStatus.OK);
    }
}
