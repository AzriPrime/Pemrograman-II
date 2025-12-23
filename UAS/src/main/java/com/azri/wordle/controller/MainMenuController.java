package com.azri.wordle.controller;

import com.azri.wordle.Main;
import com.azri.wordle.dao.HighScoreDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.io.IOException;

public class MainMenuController {

    @FXML
    private ListView<String> highScoreList;

    @FXML
    public void initialize() {
        loadHighScores();
    }

    private void loadHighScores() {
        HighScoreDAO dao = new HighScoreDAO();
        dao.getTopScores().forEach(score -> 
            highScoreList.getItems().add(score.getScore() + " Words - " + score.getAchievedAt())
        );
    }

    @FXML
    private void onPlay() throws IOException {
        Main.setRoot("game_view");
    }

    @FXML
    private void onDictionary() throws IOException {
        Main.setRoot("dictionary_manager");
    }

    @FXML
    private void onExit() {
        System.exit(0);
    }
}
