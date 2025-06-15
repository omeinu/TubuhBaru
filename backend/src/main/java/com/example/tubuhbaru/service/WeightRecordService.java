package com.example.tubuhbaru.service;

import com.example.tubuhbaru.model.WeightRecord;
import com.example.tubuhbaru.repository.WeightRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeightRecordService {
    private final WeightRecordRepository repository;
    private final java.util.List<SseEmitter> emitters = new java.util.concurrent.CopyOnWriteArrayList<>();

    public WeightRecordService(WeightRecordRepository repository) {
        this.repository = repository;
    }

    public void addEmitter(SseEmitter emitter) {
        emitters.add(emitter);
    }

    public void removeEmitter(SseEmitter emitter) {
        emitters.remove(emitter);
    }

    public WeightRecord registerWeight(double weight, LocalDateTime recordedAt) {
        WeightRecord record = repository.save(weight, recordedAt);
        emitters.forEach(emitter -> {
            try {
                emitter.send(record);
            } catch (Exception e) {
                emitter.complete();
                emitters.remove(emitter);
            }
        });
        return record;
    }

    public List<WeightRecord> getAllWeights() {
        return repository.findAll();
    }
}
