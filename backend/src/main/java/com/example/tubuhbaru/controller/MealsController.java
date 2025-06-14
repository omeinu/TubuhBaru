package com.example.tubuhbaru.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
public class MealsController {

    @PostMapping("/api/meals")
    public ResponseEntity<Map<String, String>> uploadMeal(
            @RequestParam("menuText") String menuText,
            @RequestParam("image") MultipartFile image) throws IOException {
        long size = image.getSize();
        String filename = image.getOriginalFilename();
        String message = String.format("Received %s (%d bytes) with text '%s'", filename, size, menuText);
        return ResponseEntity.ok(Map.of("status", "ok", "message", message));
    }
}
