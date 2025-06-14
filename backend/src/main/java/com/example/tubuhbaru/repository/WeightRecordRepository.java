package com.example.tubuhbaru.repository;

import com.example.tubuhbaru.model.WeightRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class WeightRecordRepository {
    private final List<WeightRecord> records = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public WeightRecord save(double weight, LocalDateTime recordedAt) {
        WeightRecord record = new WeightRecord(idGenerator.getAndIncrement(), weight, recordedAt);
        records.add(record);
        return record;
    }

    public List<WeightRecord> findAll() {
        return List.copyOf(records);
    }
}
