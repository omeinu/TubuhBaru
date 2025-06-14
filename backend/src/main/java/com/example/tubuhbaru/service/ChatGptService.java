package com.example.tubuhbaru.service;

import org.springframework.stereotype.Service;

@Service
public class ChatGptService {
    // Stub implementation that mimics calling the ChatGPT API
    public String analyze(String menuText) {
        // In a real implementation, the text would be sent to OpenAI API (gpt-4-turbo)
        return "analysis for: " + menuText;
    }
}
