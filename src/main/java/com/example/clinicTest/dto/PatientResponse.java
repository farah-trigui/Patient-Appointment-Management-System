package com.example.clinicTest.dto;

public record PatientResponse(
    Long id,
    String name,
    String email,
    String phone
) {}

