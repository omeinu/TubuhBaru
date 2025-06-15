package com.example.tubuhbaru.service;

import com.example.tubuhbaru.model.MealRecord;
import com.example.tubuhbaru.repository.MealRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MealRecordService {
    private final MealRecordRepository repository;
    private final ChatGptService chatGptService;

    public MealRecordService(MealRecordRepository repository,
                             ChatGptService chatGptService) {
        this.repository = repository;
        this.chatGptService = chatGptService;
    }

    public MealRecord registerMeal(String menuText) {
        String aiComment = chatGptService.analyze(menuText);
        LocalDateTime createdAt = LocalDateTime.now();
        return repository.save(menuText, aiComment, createdAt);
    }

    public java.util.List<MealRecord> getAllMeals() {
        return repository.findAll();
    }
}
