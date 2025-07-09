package com.example.clinicTest.dto;

import java.time.LocalDateTime;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AppointmentRequest (
    LocalDateTime dateTime,
    @NotBlank @Size(min=1) String reason,
    @NotNull Long patientId
){}
