package com.example.tubuhbaru.controller;

import com.example.tubuhbaru.model.MealRecord;
import com.example.tubuhbaru.service.MealRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class MealRecordController {
    private final MealRecordService service;

    public MealRecordController(MealRecordService service) {
        this.service = service;
    }

    @PostMapping("/api/meals")
    public ResponseEntity<MealRecord> uploadMeal(@RequestBody Map<String, String> body) {
        MealRecord record = service.registerMeal(body.get("menuText"));
        return ResponseEntity.ok(record);
    }

    @GetMapping("/api/meals")
    public ResponseEntity<java.util.List<MealRecord>> getMeals() {
        return ResponseEntity.ok(service.getAllMeals());
    }
}
