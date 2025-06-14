package com.example.tubuhbaru.model;

public class MealRecord {
    private final long id;
    private final String menuText;
    private final String imageUrl;
    private final String analysis;

    public MealRecord(long id, String menuText, String imageUrl, String analysis) {
        this.id = id;
        this.menuText = menuText;
        this.imageUrl = imageUrl;
        this.analysis = analysis;
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

    public String getAnalysis() {
        return analysis;
    }
}
