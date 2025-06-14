package com.example.tubuhbaru.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class ChatGptClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public String analyze(String text) {
        // TODO: Replace with actual ChatGPT API call
        // This is a placeholder implementation
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer YOUR_OPENAI_API_KEY");
        String body = "{\"prompt\":\"" + text + "\", \"max_tokens\":100}";
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.openai.com/v1/completions",
                HttpMethod.POST,
                entity,
                String.class
        );
        return response.getBody();
    }
}
