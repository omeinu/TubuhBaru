package com.example.tubuhbaru.controller;

import com.example.tubuhbaru.model.WeightRecord;
import com.example.tubuhbaru.service.WeightRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

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

    @GetMapping("/api/weights/stream")
    public SseEmitter streamWeights() {
        SseEmitter emitter = new SseEmitter();
        service.addEmitter(emitter);
        emitter.onCompletion(() -> service.removeEmitter(emitter));
        emitter.onTimeout(() -> service.removeEmitter(emitter));
        return emitter;
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
