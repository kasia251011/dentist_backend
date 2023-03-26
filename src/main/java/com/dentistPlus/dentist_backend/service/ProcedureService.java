package com.dentistPlus.dentist_backend.service;

import com.dentistPlus.dentist_backend.model.Procedure;
import com.dentistPlus.dentist_backend.repository.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProcedureService {
    private final ProcedureRepository procedureRepository;

    @Autowired
    public ProcedureService(ProcedureRepository procedureRepository) {
        this.procedureRepository = procedureRepository;
    }

    public Procedure addProcedure(Procedure procedure) {
        procedureRepository.save(procedure);
        return procedure;
    }

    public List<Procedure> getProcedures() {
        return  (List<Procedure>) procedureRepository.findAll();
    }

    public Procedure getProcedure(Long id) {
        return  procedureRepository.findById(id).orElseThrow(() -> new RuntimeException("No procedure of this id found"));
    }

    public Procedure deleteProcedure(Long procedureId) {
        Procedure procedure = getProcedure(procedureId);
        procedureRepository.delete(procedure);
        return procedure;
    }

    public Procedure editProcedure(Long id, Procedure editedProcedure) {
        Procedure procedure = getProcedure(id);
        procedure.setValues(editedProcedure);
        procedureRepository.save(procedure);
        return  procedure;
    }
}
