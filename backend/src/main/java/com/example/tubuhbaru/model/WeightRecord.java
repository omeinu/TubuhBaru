package com.example.tubuhbaru.model;

import java.time.LocalDateTime;

public class WeightRecord {
    private final double weight;
    private final LocalDateTime recordedAt;

    public WeightRecord(double weight, LocalDateTime recordedAt) {
        this.weight = weight;
        this.recordedAt = recordedAt;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }
}
