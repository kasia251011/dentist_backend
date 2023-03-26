package com.dentistPlus.dentist_backend.repository;

import com.dentistPlus.dentist_backend.model.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRepository extends CrudRepository<Procedure, Long> {
}
