package com.example.tubuhbaru.model;

import java.time.LocalDateTime;

public class MealRecord {
    private final long id;
    private final String menuText;
    private final String aiComment;
    private final LocalDateTime createdAt;

    public MealRecord(long id, String menuText, String aiComment, LocalDateTime createdAt) {
        this.id = id;
        this.menuText = menuText;
        this.aiComment = aiComment;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getMenuText() {
        return menuText;
    }


    public String getAiComment() {
        return aiComment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
