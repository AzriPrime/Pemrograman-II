# IndoWordle Roulette (Endless Arcade)

A JavaFX Wordle Game with a twist!

## Game Mechanics
- **Objective**: Solve as many Indonesian words as possible.
- **The Twist**: Every **6th unique letter** you type triggers a "Russian Roulette" check.
    - Start with **1 bullet** in the chamber (1/6 chance).
    - Gain +1 bullet for every **5 words solved** (Max 4).
    - If the gun fires, it's **GAME OVER**.
- **Scoring**: Your score is the total number of words solved.

## Requirements
- Java 17 or higher.
- Maven (optional, but recommended for building).

## How to Run
### Option 1: IntelliJ IDEA / Eclipse (Recommended)
1. Open this folder as a Project.
2. Allow the IDE to import Maven dependencies (`pom.xml`).
3. Run `src/main/java/com/azri/wordle/Main.java`.

### Option 2: Command Line (Requires Maven)
1. Open a terminal in this directory.
2. Run: `mvn javafx:run`

### Option 3: Build Executable JAR
1.  Run: `mvn clean package`
2.  Find the JAR in `target/IndoWordleRoulette-1.0-SNAPSHOT.jar`
3.  Run it: `java -jar target/IndoWordleRoulette-1.0-SNAPSHOT.jar`

## Implementation Details
- **OOP Principles**:
    - **Abstract Class**: `GameSession` handles score/state.
    - **Inheritance**: `EndlessRouletteSession` adds specific mechanics.
    - **Interfaces**: `MechanicEvent` for callback logic.
    - **Encapsulation**: Private fields with Getters/Setters.
- **Database**:
    - Uses **H2 Embedded Database** (`library.db`).
    - Tables: `words` (Dictionary), `high_scores`.
    - **DAO Pattern**: `DictionaryDAO`, `HighScoreDAO`.
