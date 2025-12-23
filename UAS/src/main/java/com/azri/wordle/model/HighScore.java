package com.azri.wordle.model;

public class HighScore {
    private int id;
    private int score;
    private String achievedAt;

    public HighScore(int id, int score, String achievedAt) {
        this.id = id;
        this.score = score;
        this.achievedAt = achievedAt;
    }

    // Overloaded Constructor (Requirement g: Polymorphism)
    public HighScore(int score) {
        this.id = -1; // Temporary ID
        this.score = score;
        this.achievedAt = java.time.LocalDate.now().toString();
    }

    public int getScore() {
        return score;
    }

    public String getAchievedAt() {
        return achievedAt;
    }
}
