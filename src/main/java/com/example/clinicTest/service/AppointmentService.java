package com.example.clinicTest.service;

import com.example.clinicTest.dto.AppointmentRequest;
import com.example.clinicTest.dto.AppointmentResponse;
import com.example.clinicTest.entity.Appointment;
import com.example.clinicTest.entity.Patient;
import com.example.clinicTest.repository.AppointmentRepository;
import com.example.clinicTest.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    public AppointmentResponse create(AppointmentRequest request) {
        Patient patient = patientRepository.findById(request.patientId())
            .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        Appointment appointment = new Appointment(
            null,
            request.dateTime(),
            request.reason(),
            patient
        );

        Appointment saved = appointmentRepository.save(appointment);

        return new AppointmentResponse(
            saved.getId(),
            saved.getPatient().getId(),
            saved.getDateTime(),
            saved.getReason()
        );
    }

    public List<AppointmentResponse> getAll() {
        return appointmentRepository.findAll().stream()
            .map(a -> new AppointmentResponse(
                a.getId(),
                a.getPatient().getId(),
                a.getDateTime(),
                a.getReason()
            )).toList();
    }
}
