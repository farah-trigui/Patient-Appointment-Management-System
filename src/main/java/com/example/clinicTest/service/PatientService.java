package com.example.clinicTest.service;

import com.example.clinicTest.dto.PatientRequest;
import com.example.clinicTest.dto.PatientResponse;
import com.example.clinicTest.entity.Patient;
import com.example.clinicTest.repository.PatientRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service


public class PatientService {
    private final PatientRepository repository;

     public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public PatientResponse create(PatientRequest request){
        if (repository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email already exists");
        }
        Patient patient = new Patient(null,request.name(), request.email(), request.phone());
        Patient saved = repository.save(patient);
        return new PatientResponse(saved.getId(), saved.getName(), saved.getEmail(), saved.getPhone());

    }
    
    public List<PatientResponse> getAll(){
        return repository.findAll().stream()
            .map(p-> new PatientResponse(p.getId(),
            p.getName(), p.getEmail(), p.getPhone()))
            .toList();
    }
    
}
