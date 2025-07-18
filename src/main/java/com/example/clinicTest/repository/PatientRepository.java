package com.example.clinicTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinicTest.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
    boolean existsByEmail(String email);
    
}
