package com.example.tubuhbaru.controller;

import com.example.tubuhbaru.service.MealRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/meal-records")
public class MealRecordController {

    private final MealRecordService mealRecordService;

    public MealRecordController(MealRecordService mealRecordService) {
        this.mealRecordService = mealRecordService;
    }

    @PostMapping
    public ResponseEntity<?> uploadMealRecord(
            @RequestPart("image") MultipartFile image,
            @RequestPart("menuText") String menuText
    ) {
        mealRecordService.processMealRecord(image, menuText);
        return ResponseEntity.ok().build();
    }
}
