package com.example.clinicTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinicTest.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    
}
