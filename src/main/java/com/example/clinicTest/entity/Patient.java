package com.example.clinicTest.entity;

import jakarta.validation.constraints.*;
import lombok.*;

import jakarta.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;


    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @Size(min =8, max = 15)
    private String phone;

    



}
