package com.example.clinicTest.controller;

import com.example.clinicTest.dto.AppointmentRequest;
import com.example.clinicTest.dto.AppointmentResponse;
import com.example.clinicTest.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentResponse> create(@RequestBody AppointmentRequest request) {
        AppointmentResponse created = appointmentService.create(request);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAll() {
        return ResponseEntity.ok(appointmentService.getAll());
    }
}
