package com.example.tubuhbaru.service;

import com.example.tubuhbaru.model.WeightRecord;
import com.example.tubuhbaru.repository.WeightRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WeightRecordService {
    private final WeightRecordRepository repository;

    public WeightRecordService(WeightRecordRepository repository) {
        this.repository = repository;
    }

    public WeightRecord addWeight(double weight, LocalDateTime recordedAt) {
        return repository.save(weight, recordedAt);
    }
}
