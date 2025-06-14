package com.example.tubuhbaru.service;

import com.example.tubuhbaru.model.MealRecord;
import com.example.tubuhbaru.repository.MealRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MealRecordService {
    private final MealRecordRepository repository;

    public MealRecordService(MealRecordRepository repository) {
        this.repository = repository;
    }

    public MealRecord processMeal(MultipartFile file, String menuText) throws IOException {
        String imageUrl = uploadToS3(file);
        String analysis = analyzeMenu(menuText);
        return repository.save(menuText, imageUrl, analysis);
    }

    // Stub method that pretends to upload to S3
    private String uploadToS3(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        long size = file.getSize();
        // In a real implementation, the file would be uploaded to S3 here
        return "https://s3.example.com/" + filename;
    }

    // Stub method that pretends to call ChatGPT API
    private String analyzeMenu(String menuText) {
        // In a real implementation, menuText would be sent to the ChatGPT API
        return "analysis for: " + menuText;
    }
}
