package com.example.spring_dec2025.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name="doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="doctor_name", nullable = false)
    private String name;

    @Column(name="email", nullable =false)
    private String email;

    @Column(name="specialization", nullable=false)
    private String specialization;

    @Column(name="dob", nullable=false)
    private String dob;

    @Column(name="mobile", nullable = false)
    private String mobile;



}
