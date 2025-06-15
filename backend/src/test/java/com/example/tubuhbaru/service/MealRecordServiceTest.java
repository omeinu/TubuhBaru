package com.example.tubuhbaru.service;

import com.example.tubuhbaru.repository.MealRecordRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealRecordServiceTest {
    @Test
    void processMealStoresRecord() throws Exception {
        MealRecordRepository repository = new MealRecordRepository();
        ChatGptService chatGptService = new ChatGptService();
        MealRecordService service = new MealRecordService(repository, chatGptService);
        var record = service.registerMeal("rice and fish");
        assertEquals("rice and fish", record.getMenuText());
        assertEquals("analysis for: rice and fish", record.getAiComment());
        assertEquals(1, repository.findAll().size());
    }
}
