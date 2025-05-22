package com.parth.health.healthtracker.controller;

import com.parth.health.healthtracker.model.Metric;
import com.parth.health.healthtracker.repository.MetricRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metrics")
public class MetricController {

    private final MetricRepository metricRepository;

    public MetricController(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @PostMapping
    public Metric createMetric(@RequestBody Metric metric) {
        return metricRepository.save(metric);
    }

    @GetMapping
    public List<Metric> getAllMetrics() {
        return metricRepository.findAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Metric updateMetric(@PathVariable Long id, @RequestBody Metric updatedMetric) {


        Optional<Metric> optionalMetric = metricRepository.findById(id);
        if (optionalMetric.isPresent()) {
            Metric metric = optionalMetric.get();
            metric.setType(updatedMetric.getType());
            metric.setValue(updatedMetric.getValue());
            metric.setTimestamp(LocalDateTime.now());
            return metricRepository.save(metric);
        } else {
            throw new RuntimeException("Metric not found with id: " + id);
        }

    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteMetric(@PathVariable Long id) {
        metricRepository.deleteById(id);
        return "Metric with ID " + id + " deleted.";
    }
}


