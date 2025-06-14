package com.example.tubuhbaru.controller;

import com.example.tubuhbaru.model.WeightRecord;
import com.example.tubuhbaru.service.WeightRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class WeightRecordController {
    private final WeightRecordService service;

    public static class WeightResponse {
        public double weight;
        public LocalDateTime recordedAt;

        public WeightResponse(double weight, LocalDateTime recordedAt) {
            this.weight = weight;
            this.recordedAt = recordedAt;
        }
    }

    public static class WeightRequest {
        public double weight;
        public LocalDateTime recordedAt;
    }

    public WeightRecordController(WeightRecordService service) {
        this.service = service;
    }

    @PostMapping("/api/weights")
    public ResponseEntity<WeightRecord> registerWeight(@RequestBody WeightRequest request) {
        WeightRecord record = service.registerWeight(request.weight, request.recordedAt);
        return ResponseEntity.ok(record);
    }

    @GetMapping("/api/weights")
    public ResponseEntity<java.util.List<WeightResponse>> getWeights() {
        var list = service.getAllWeights().stream()
                .map(r -> new WeightResponse(r.getWeight(), r.getRecordedAt()))
                .toList();
        return ResponseEntity.ok(list);
    }
}
