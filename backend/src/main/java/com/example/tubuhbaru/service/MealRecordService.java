package com.example.tubuhbaru.service;

import com.example.tubuhbaru.model.MealRecord;
import com.example.tubuhbaru.repository.MealRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class MealRecordService {
    private final MealRecordRepository repository;
    private final S3Service s3Service;
    private final ChatGptService chatGptService;

    public MealRecordService(MealRecordRepository repository,
                             S3Service s3Service,
                             ChatGptService chatGptService) {
        this.repository = repository;
        this.s3Service = s3Service;
        this.chatGptService = chatGptService;
    }

    public MealRecord registerMeal(String menuText, MultipartFile image) throws IOException {
        String imageUrl = s3Service.uploadImage(image);
        String aiComment = chatGptService.analyze(menuText);
        LocalDateTime createdAt = LocalDateTime.now();
        return repository.save(menuText, imageUrl, aiComment, createdAt);
    }
}
