package com.example.tubuhbaru.model;

import java.time.LocalDateTime;

public class WeightRecord {
    private final long id;
    private final double weight;
    private final LocalDateTime recordedAt;

    public WeightRecord(long id, double weight, LocalDateTime recordedAt) {
        this.id = id;
        this.weight = weight;
        this.recordedAt = recordedAt;
    }

    public long getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }
}
