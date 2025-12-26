package com.example.spring_dec2025.repository;

import com.example.spring_dec2025.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
