package com.example.tubuhbaru.service;

import com.example.tubuhbaru.repository.WeightRecordRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class WeightRecordServiceTest {
    @Test
    void registerWeightStoresRecord() {
        WeightRecordRepository repository = new WeightRecordRepository();
        WeightRecordService service = new WeightRecordService(repository);
        LocalDateTime t = LocalDateTime.now();
        var record = service.registerWeight(70.5, t);
        assertEquals(70.5, record.getWeight());
        assertEquals(t, record.getRecordedAt());
        assertEquals(1, repository.findAll().size());
    }
}
