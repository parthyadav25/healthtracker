package com.parth.health.healthtracker.repository;


import com.parth.health.healthtracker.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<Metric, Long> {
}

