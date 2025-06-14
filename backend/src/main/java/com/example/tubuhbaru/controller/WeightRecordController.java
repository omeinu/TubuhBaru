package com.example.tubuhbaru.controller;

import com.example.tubuhbaru.model.WeightRecord;
import com.example.tubuhbaru.service.WeightRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeightRecordController {
    private final WeightRecordService service;

    public WeightRecordController(WeightRecordService service) {
        this.service = service;
    }

    @GetMapping("/api/weights")
    public List<WeightRecord> getWeights() {
        return service.getAllWeights();
    }
}
