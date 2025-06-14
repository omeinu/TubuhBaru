package com.example.tubuhbaru.repository;

import com.example.tubuhbaru.model.MealRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MealRecordRepository {
    private final List<MealRecord> records = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public MealRecord save(String menuText, String imageUrl, String aiComment, LocalDateTime createdAt) {
        MealRecord record = new MealRecord(idGenerator.getAndIncrement(), menuText, imageUrl, aiComment, createdAt);
        records.add(record);
        return record;
    }

    public List<MealRecord> findAll() {
        return List.copyOf(records);
    }
}
