package com.azri.wordle.controller;

import com.azri.wordle.Main;
import com.azri.wordle.dao.DictionaryDAO;
import com.azri.wordle.dao.HighScoreDAO;
import com.azri.wordle.model.EndlessRouletteSession;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.util.Duration;

import java.io.IOException;

public class GameController {

    @FXML
    private GridPane wordGrid;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label feedbackLabel;
    @FXML
    private Label bulletCountLabel;
    @FXML
    private Label uniqueLettersLabel;
    @FXML
    private GridPane rootPane;
    @FXML
    private javafx.scene.layout.VBox keyboardContainer;

    private EndlessRouletteSession session;
    private StringBuilder currentGuess;
    private int currentRow;

    // Grid Constants
    private static final int COLS = 5;
    private static final int ROWS = 6;
    private Rectangle[][] gridBackgrounds;
    private Text[][] gridTexts;

    // Keyboard State
    private java.util.Map<Character, javafx.scene.control.Button> keyButtons = new java.util.HashMap<>();
    private java.util.Map<Character, Integer> keyStatus = new java.util.HashMap<>();

    public void initialize() {
        DictionaryDAO dictDAO = new DictionaryDAO();
        session = new EndlessRouletteSession();

        initKeyboard();
        startNewRound(dictDAO);

        initGrid();

        // Key Listener attached to Scene
        rootPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(this::handleInput);
            }
        });

        updateStats();
    }

    private void startNewRound(DictionaryDAO dao) {
        String nextWord = dao.getRandomWord(session.getUsedWords());

        if (nextWord.equals("HABIS")) {
            feedbackLabel.setText("VICTORY! Dictionary Cleared.");
            showVictoryAlert();
            return;
        }

        session.startNewRound(nextWord);
        currentRow = 0;
        currentGuess = new StringBuilder();

        // Visual Reset (Keep Score)
        if (gridBackgrounds != null) {
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    gridTexts[r][c].setText("");
                    gridBackgrounds[r][c].setFill(Color.TRANSPARENT);
                    gridBackgrounds[r][c].setStroke(Color.GRAY);
                }
            }
        }
        feedbackLabel.setText(""); // Clearing persistent label
        initKeyboard(); // Reset Keyboard colors
        System.out.println("DEBUG: Target Word is " + nextWord);
    }

    private void initGrid() {
        gridBackgrounds = new Rectangle[ROWS][COLS];
        gridTexts = new Text[ROWS][COLS];

        wordGrid.getChildren().clear();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                StackPane cell = new StackPane();
                Rectangle bg = new Rectangle(50, 50);
                bg.setFill(Color.TRANSPARENT);
                bg.setStroke(Color.GRAY);
                bg.setArcWidth(10);
                bg.setArcHeight(10);

                Text text = new Text("");
                text.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-fill: white;");

                gridBackgrounds[r][c] = bg;
                gridTexts[r][c] = text;

                cell.getChildren().addAll(bg, text);
                wordGrid.add(cell, c, r);
            }
        }
    }

    private void initKeyboard() {
        if (keyboardContainer == null)
            return;
        keyboardContainer.getChildren().clear();
        keyButtons.clear();
        keyStatus.clear();
        String[] rows = { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };

        for (String row : rows) {
            javafx.scene.layout.HBox hbox = new javafx.scene.layout.HBox(5);
            hbox.setAlignment(javafx.geometry.Pos.CENTER);
            for (char c : row.toCharArray()) {
                javafx.scene.control.Button btn = new javafx.scene.control.Button(String.valueOf(c));
                btn.setPrefWidth(40);
                btn.setPrefHeight(40);
                btn.getStyleClass().add("keyboard-button");
                btn.setStyle("-fx-background-color: #818384; -fx-text-fill: white;");
                btn.setFocusTraversable(false);

                keyButtons.put(c, btn);
                keyStatus.put(c, 0);
                hbox.getChildren().add(btn);
            }
            keyboardContainer.getChildren().add(hbox);
        }
    }

    private void updateKeyboardColor(char letter, int status) {
        int current = keyStatus.getOrDefault(letter, 0);
        if (status > current) {
            keyStatus.put(letter, status);
            javafx.scene.control.Button btn = keyButtons.get(letter);
            if (btn != null) {
                switch (status) {
                    case 1:
                        btn.setStyle("-fx-background-color: #3a3a3c; -fx-text-fill: white;");
                        break; // Absent
                    case 2:
                        btn.setStyle("-fx-background-color: #b59f3b; -fx-text-fill: white;");
                        break; // Present
                    case 3:
                        btn.setStyle("-fx-background-color: #538d4e; -fx-text-fill: white;");
                        break; // Correct
                }
            }
        }
    }

    private void handleInput(KeyEvent event) {
        if (!session.isAlive())
            return;
        if (feedbackLabel.getText().startsWith("TRIGGERED"))
            return;

        String code = event.getCode().toString();

        if (code.equals("BACK_SPACE")) {
            if (currentGuess.length() > 0) {
                currentGuess.deleteCharAt(currentGuess.length() - 1);
                updateGridRow();
            }
        } else if (code.equals("ENTER")) {
            if (currentGuess.length() == 5) {
                submitGuess();
            }
        } else if (code.matches("^[A-Z]$")) {
            if (currentGuess.length() < 5) {
                char letter = code.charAt(0);
                currentGuess.append(letter);
                updateGridRow();
            }
        } else if (code.equals("ESCAPE")) {
            try {
                Main.setRoot("main_menu");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGridRow() {
        for (int i = 0; i < 5; i++) {
            if (i < currentGuess.length()) {
                gridTexts[currentRow][i].setText(String.valueOf(currentGuess.charAt(i)));
            } else {
                gridTexts[currentRow][i].setText("");
            }
        }
    }

    private void handleRouletteTrigger(boolean survived, int bullets, double risk) {
        feedbackLabel.setText("TRIGGERED! Spin...");
        feedbackLabel.setStyle("-fx-text-fill: orange;");

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
            if (survived) {
                feedbackLabel.setText("CLICK! Safe. (" + bullets + "/6)");
                feedbackLabel.setStyle("-fx-text-fill: white;");
            } else {
                feedbackLabel.setText("BANG! Game Over.");
                feedbackLabel.setStyle("-fx-text-fill: red;");
                endGame();
            }
            updateStats();
        });
        pause.play();
    }

    private void submitGuess() {
        String guess = currentGuess.toString();
        String target = session.getTargetWord();

        // 1. Calculate Colors (Standard Wordle Logic)
        char[] guessChars = guess.toCharArray();
        char[] targetChars = target.toCharArray();
        Color[] results = new Color[5];

        java.util.Map<Character, Integer> targetFreq = new java.util.HashMap<>();
        for (char c : targetChars)
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);

        // Pass 1: Greens
        for (int i = 0; i < 5; i++) {
            if (guessChars[i] == targetChars[i]) {
                results[i] = Color.GREEN;
                targetFreq.put(guessChars[i], targetFreq.get(guessChars[i]) - 1);
                updateKeyboardColor(guessChars[i], 3);
            }
        }

        // Pass 2: Yellows/Grays
        for (int i = 0; i < 5; i++) {
            if (results[i] == Color.GREEN)
                continue;
            char c = guessChars[i];
            if (targetFreq.getOrDefault(c, 0) > 0) {
                results[i] = Color.GOLDENROD;
                targetFreq.put(c, targetFreq.get(c) - 1);
                updateKeyboardColor(c, 2);
            } else {
                results[i] = Color.DARKGRAY;
                updateKeyboardColor(c, 1);
            }
        }

        // Apply Colors
        for (int i = 0; i < 5; i++) {
            gridBackgrounds[currentRow][i].setFill(results[i]);
        }

        // 2. Check Win Condition
        if (guess.equals(target)) {
            // Winning Guess: DO NOT TRIGGER MECHANIC aka "Keys Pressed"
            session.submitGuess(guess);
            updateStats();
            feedbackLabel.setText("Correct! Next Word...");
            feedbackLabel.setStyle("-fx-text-fill: cyan;");

            PauseTransition next = new PauseTransition(Duration.seconds(1.5));
            next.setOnFinished(e -> startNewRound(new DictionaryDAO()));
            next.play();
            return;
        }

        // 3. Mechanic Trigger (Only if NOT won)
        // This validates "Keys Pressed will only increment if the word entered is
        // wrong"
        session.processGuessMechanic(guess, this::handleRouletteTrigger);

        if (!session.isAlive()) {
            return;
        }

        currentRow++;
        if (currentRow >= ROWS) {
            endGame();
        }
        currentGuess.setLength(0);
        updateStats();
    }

    private void updateStats() {
        scoreLabel.setText("Words Solved: " + session.getCurrentScore());
        bulletCountLabel.setText("Bullets: " + session.getBulletCount() + "/6");
        int count = session.getUniqueLetterCount();
        uniqueLettersLabel.setText("Trigger: " + (count % 6) + "/6");
    }

    private void endGame() {
        HighScoreDAO dao = new HighScoreDAO();
        dao.saveScore(session.getCurrentScore());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("You died!");
        alert.setContentText(
                "The word was: " + session.getTargetWord() + "\nScore: " + session.getCurrentScore() + " Words.");
        alert.setOnHidden(e -> {
            try {
                Main.setRoot("main_menu");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        alert.show();
    }

    private void showVictoryAlert() {
        HighScoreDAO dao = new HighScoreDAO();
        dao.saveScore(session.getCurrentScore());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("VICTORY");
        alert.setHeaderText("Dictionary Conquered!");
        alert.setContentText(
                "You have correctly guessed ALL words in the dictionary!\nFinal Score: " + session.getCurrentScore());
        alert.setOnHidden(e -> {
            try {
                Main.setRoot("main_menu");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        alert.show();
    }
}
