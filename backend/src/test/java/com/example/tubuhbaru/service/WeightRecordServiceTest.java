package com.example.tubuhbaru.service;

import com.example.tubuhbaru.repository.WeightRecordRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class WeightRecordServiceTest {
    @Test
    void addWeightStoresRecord() {
        WeightRecordRepository repository = new WeightRecordRepository();
        WeightRecordService service = new WeightRecordService(repository);
        LocalDateTime dt = LocalDateTime.of(2023, 1, 1, 8, 0);
        var record = service.addWeight(65.5, dt);
        assertEquals(65.5, record.getWeight());
        assertEquals(dt, record.getRecordedAt());
        assertEquals(1, repository.findAll().size());
    }
}
