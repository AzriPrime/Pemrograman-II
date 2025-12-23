package com.azri.wordle.model;

/**
 * Abstract Base Class for a Game Session.
 * Manages the high-level state of a game run (score, alive status).
 */
public abstract class GameSession {
    protected int currentScore;
    protected boolean isAlive;
    protected String currentTargetWord;

    public GameSession() {
        this.currentScore = 0;
        this.isAlive = true;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void incrementScore() {
        this.currentScore++;
    }

    public void setTargetWord(String word) {
        this.currentTargetWord = word;
    }

    public String getTargetWord() {
        return currentTargetWord;
    }

    // Abstract methods to be implemented by concrete sessions
    public abstract void submitGuess(String guess);
    public abstract void onLetterInput(char letter, MechanicEvent callback);
}
