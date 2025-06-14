package com.example.tubuhbaru.repository;

import com.example.tubuhbaru.model.WeightRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WeightRecordRepository {
    private final List<WeightRecord> records = new ArrayList<>();

    public WeightRecord save(double weight, LocalDateTime recordedAt) {
        WeightRecord record = new WeightRecord(weight, recordedAt);
        records.add(record);
        return record;
    }

    public List<WeightRecord> findAll() {
        return List.copyOf(records);
    }
}
