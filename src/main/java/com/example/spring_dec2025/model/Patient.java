package com.example.spring_dec2025.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="patient_name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="gender")
    private String gender;

    @Column(name="disease")
    private String disease;

    @Column(name="mobile")
    private String mobile;
}
