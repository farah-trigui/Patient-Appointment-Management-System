package com.example.clinicTest.dto;

import java.time.LocalDateTime;

public record AppointmentResponse(
    Long id,
    Long patientId,
    LocalDateTime dateTime,
    String reason
    
) {}

