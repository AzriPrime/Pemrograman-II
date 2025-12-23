package com.azri.wordle.model;

/**
 * Functional interface for game mechanic events.
 * Used to trigger UI effects when specific game logic events occur (like the Roulette firing).
 */
@FunctionalInterface
public interface MechanicEvent {
    void onTrigger(boolean survived, int chamberCount, double riskProbability);
}
