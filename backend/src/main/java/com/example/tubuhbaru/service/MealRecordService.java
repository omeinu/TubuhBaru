package com.example.tubuhbaru.service;

import com.example.tubuhbaru.model.MealRecord;
import com.example.tubuhbaru.repository.MealRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MealRecordService {

    private final MealRecordRepository repository;
    private final S3Uploader s3Uploader;
    private final ChatGptClient chatGptClient;

    public MealRecordService(MealRecordRepository repository,
                             S3Uploader s3Uploader,
                             ChatGptClient chatGptClient) {
        this.repository = repository;
        this.s3Uploader = s3Uploader;
        this.chatGptClient = chatGptClient;
    }

    public void processMealRecord(MultipartFile image, String menuText) {
        String imageUrl = s3Uploader.upload(image);
        String analysis = chatGptClient.analyze(menuText);

        MealRecord record = new MealRecord();
        record.setImageUrl(imageUrl);
        record.setAnalysis(analysis);
        repository.save(record);
    }
}
