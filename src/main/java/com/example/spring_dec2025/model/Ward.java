package com.example.spring_dec2025.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wards")
public class Ward {

    @Id
    @Column(name="id", nullable = false)
    public int id;

    @Column(name="name", nullable = false)
    public String name;

    @Column(name="occupiedBeds", nullable = false)
    public int occupiedBeds;

    @Column(name="capacity", nullable = false)
    public int capacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccupiedBeds() {
        return occupiedBeds;
    }

    public void setOccupiedBeds(int occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
