package com.example.tubuhbaru.controller;

import com.example.tubuhbaru.model.MealRecord;
import com.example.tubuhbaru.service.MealRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MealRecordController {
    private final MealRecordService service;

    public MealRecordController(MealRecordService service) {
        this.service = service;
    }

    @PostMapping("/api/meals")
    public ResponseEntity<MealRecord> uploadMeal(
            @RequestParam("menuText") String menuText,
            @RequestParam("image") MultipartFile image) throws IOException {
        MealRecord record = service.registerMeal(menuText, image);
        return ResponseEntity.ok(record);
    }

    @GetMapping("/api/meals")
    public ResponseEntity<java.util.List<MealRecord>> getMeals() {
        return ResponseEntity.ok(service.getAllMeals());
    }
}
