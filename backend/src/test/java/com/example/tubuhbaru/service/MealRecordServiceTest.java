package com.example.tubuhbaru.service;

import com.example.tubuhbaru.repository.MealRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.*;

class MealRecordServiceTest {
    @Test
    void processMealStoresRecord() throws Exception {
        MealRecordRepository repository = new MealRecordRepository();
        MealRecordService service = new MealRecordService(repository);
        MockMultipartFile file = new MockMultipartFile("image", "test.jpg", "image/jpeg", new byte[]{1,2,3});
        var record = service.processMeal(file, "rice and fish");
        assertEquals("rice and fish", record.getMenuText());
        assertEquals("https://s3.example.com/test.jpg", record.getImageUrl());
        assertEquals("analysis for: rice and fish", record.getAnalysis());
        assertEquals(1, repository.findAll().size());
    }
}
