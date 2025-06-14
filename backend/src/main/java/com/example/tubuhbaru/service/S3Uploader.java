package com.example.tubuhbaru.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class S3Uploader {

    public String upload(MultipartFile file) {
        // TODO: Implement actual AWS S3 upload logic
        // For now, return a placeholder URL
        return "https://s3.amazonaws.com/bucket/" + file.getOriginalFilename();
    }
}
