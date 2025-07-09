package com.example.clinicTest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PatientRequest (
    @NotBlank @Size(min=3) String name,
    @NotBlank@Email String email,
    String phone
    
) {}
