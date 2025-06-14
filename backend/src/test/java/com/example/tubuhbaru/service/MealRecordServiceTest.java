package com.example.tubuhbaru.service;

import com.example.tubuhbaru.repository.MealRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.*;

class MealRecordServiceTest {
    @Test
    void processMealStoresRecord() throws Exception {
        MealRecordRepository repository = new MealRecordRepository();
        S3Service s3Service = new S3Service();
        ChatGptService chatGptService = new ChatGptService();
        MealRecordService service = new MealRecordService(repository, s3Service, chatGptService);
        MockMultipartFile file = new MockMultipartFile("image", "test.jpg", "image/jpeg", new byte[]{1,2,3});
        var record = service.registerMeal("rice and fish", file);
        assertEquals("rice and fish", record.getMenuText());
        assertEquals("https://s3.example.com/test.jpg", record.getImageUrl());
        assertEquals("analysis for: rice and fish", record.getAiComment());
        assertEquals(1, repository.findAll().size());
    }
}
