package com.parth.health.healthtracker.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;



@Entity
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // e.g., "weight", "steps", "calories"
    private double value;

    private LocalDateTime timestamp = LocalDateTime.now();

    // --- Getters & Setters ---

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
