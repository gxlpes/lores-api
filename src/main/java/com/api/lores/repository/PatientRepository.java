package com.api.lores.repository;

import com.api.lores.entity.PatientModel;
import com.api.lores.entity.embedded.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, UUID> {
    boolean existsByPersonCpfNumber(String person_cpfNumber);
}