package com.example.clinicTest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinicTest.dto.PatientRequest;
import com.example.clinicTest.dto.PatientResponse;
import com.example.clinicTest.service.PatientService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService service;

    public PatientController (PatientService service){
        this.service = service;
    }

    @GetMapping
    public  List<PatientResponse> all() {
        return service.getAll();
    }
    
    @PostMapping
    public PatientResponse create(@RequestBody @Valid PatientRequest request) {
        return service.create(request);
    }
    
}
