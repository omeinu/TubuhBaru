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
        if (repository.findAll().isEmpty()) {
            repository.save(70.0, LocalDateTime.now().minusDays(3));
            repository.save(69.5, LocalDateTime.now().minusDays(2));
            repository.save(69.0, LocalDateTime.now().minusDays(1));
        }
    }

    public List<WeightRecord> getAllWeights() {
        return repository.findAll();
    }
}
