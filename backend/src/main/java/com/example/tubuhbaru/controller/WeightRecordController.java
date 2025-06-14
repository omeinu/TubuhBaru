package com.example.tubuhbaru.controller;

import com.example.tubuhbaru.model.WeightRecord;
import com.example.tubuhbaru.service.WeightRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class WeightRecordController {
    private final WeightRecordService service;

    public WeightRecordController(WeightRecordService service) {
        this.service = service;
    }

    public static class WeightRequest {
        private double weight;
        private LocalDateTime recordedAt;

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public LocalDateTime getRecordedAt() {
            return recordedAt;
        }

        public void setRecordedAt(LocalDateTime recordedAt) {
            this.recordedAt = recordedAt;
        }
    }

    @PostMapping("/api/weights")
    public ResponseEntity<WeightRecord> addWeight(@RequestBody WeightRequest request) {
        WeightRecord record = service.addWeight(request.getWeight(), request.getRecordedAt());
        return ResponseEntity.ok(record);
    }
}
