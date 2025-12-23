package com.azri.wordle.model;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

/**
 * Concrete implementation of GameSession with "Russian Roulette" mechanics.
 */
public class EndlessRouletteSession extends GameSession {
    private Set<Character> uniqueLettersUsed;
    private int bulletCount;
    private final int MAX_BULLETS = 6;
    private final int ESCALATION_THRESHOLD = 5; // Add bullet every 5 wins
    private final Random random;

    private Set<String> usedWordsInSession;
    private int globalUniqueLetterCount = 0; // Persistent trigger counter

    public EndlessRouletteSession() {
        super();
        this.uniqueLettersUsed = new HashSet<>();
        this.usedWordsInSession = new HashSet<>();
        this.bulletCount = 1;
        this.random = new Random();
        this.globalUniqueLetterCount = 0;
    }

    public void startNewRound(String word) {
        this.setTargetWord(word);
        this.uniqueLettersUsed.clear(); // Twist Rule: 2. Reset every new word
        this.usedWordsInSession.add(word);
    }

    public int getBulletCount() {
        return bulletCount;
    }

    public int getUniqueLetterCount() {
        return globalUniqueLetterCount;
    }

    public Set<String> getUsedWords() {
        return usedWordsInSession;
    }

    @Override
    public void submitGuess(String guess) {
        if (!isAlive)
            return;

        // Note: The actual Roulette Trigger logic is handled by processGuessMechanic()
        // before this method is passed.
        // This method is called ONLY when the user wins the round (guesses correctly).

        incrementScore();

        // Check for Bullet Escalation
        if (currentScore > 0 && currentScore % ESCALATION_THRESHOLD == 0) {
            if (bulletCount < MAX_BULLETS) {
                bulletCount++;
                System.out.println("Escalation! Bullets: " + bulletCount);
            }
        }
    }

    // Helper for Controller to call with Callback
    public void processGuessMechanic(String guess, MechanicEvent callback) {
        boolean trigger = false;
        for (char c : guess.toCharArray()) {
            char normalized = Character.toUpperCase(c);
            System.out.println("Processing char: " + normalized + " | Unique Set: " + uniqueLettersUsed);
            if (uniqueLettersUsed.add(normalized)) {
                globalUniqueLetterCount++;
                if (globalUniqueLetterCount > 0 && globalUniqueLetterCount % 6 == 0) {
                    trigger = true;
                }
            }
        }
        if (trigger) {
            triggerRoulette(callback);
        }
    }

    @Override
    public void onLetterInput(char letter, MechanicEvent callback) {
        // Twist Rule 1: NO ACTION on typing.
    }

    private void triggerRoulette(MechanicEvent callback) {
        // Calculate Risk: bulletCount / 6.0
        double probability = bulletCount / 6.0;
        int chamberRoll = random.nextInt(6); // 0 to 5

        // If roll is less than bulletCount, it fires.
        boolean fired = chamberRoll < bulletCount;

        if (fired) {
            this.isAlive = false;
            callback.onTrigger(false, bulletCount, probability);
        } else {
            callback.onTrigger(true, bulletCount, probability);
        }
    }

    public void resetUniqueLetters() {
        // Legacy method, not used with current global counter logic
    }
}
