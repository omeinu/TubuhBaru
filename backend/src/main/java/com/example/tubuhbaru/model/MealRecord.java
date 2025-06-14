package com.example.tubuhbaru.model;

import java.time.LocalDateTime;

public class MealRecord {
    private final long id;
    private final String menuText;
    private final String imageUrl;
    private final String aiComment;
    private final LocalDateTime createdAt;

    public MealRecord(long id, String menuText, String imageUrl, String aiComment, LocalDateTime createdAt) {
        this.id = id;
        this.menuText = menuText;
        this.imageUrl = imageUrl;
        this.aiComment = aiComment;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getMenuText() {
        return menuText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAiComment() {
        return aiComment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
