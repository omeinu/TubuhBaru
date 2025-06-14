package com.example.tubuhbaru.service;

import com.example.tubuhbaru.model.WeightRecord;
import com.example.tubuhbaru.repository.WeightRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeightRecordService {
    private final WeightRecordRepository repository;

    public WeightRecordService(WeightRecordRepository repository) {
        this.repository = repository;
    }

    public WeightRecord registerWeight(double weight, LocalDateTime recordedAt) {
        return repository.save(weight, recordedAt);
    }

    public List<WeightRecord> getAllWeights() {
        return repository.findAll();
    }
}
