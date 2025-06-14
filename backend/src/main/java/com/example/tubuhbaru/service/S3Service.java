package com.example.tubuhbaru.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class S3Service {
    // Stub implementation that mimics uploading a file to AWS S3
    public String uploadImage(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        long size = file.getSize();
        // In a real implementation, file bytes would be uploaded here
        return "https://s3.example.com/" + filename;
    }
}
