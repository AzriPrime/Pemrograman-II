package com.azri.wordle.controller;

import com.azri.wordle.Main;
import com.azri.wordle.dao.DictionaryDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DictionaryController {

    @FXML private ListView<String> wordList;
    @FXML private TextField wordInput;

    private DictionaryDAO dictDAO = new DictionaryDAO();

    @FXML
    public void initialize() {
        loadWords();
    }

    private void loadWords() {
        wordList.setItems(FXCollections.observableArrayList(dictDAO.getAllWords()));
    }

    @FXML
    private void onAdd() {
        String word = wordInput.getText().toUpperCase();
        if (word.length() != 5) {
            showAlert("Error", "Word must be 5 letters!");
            return;
        }

        if (dictDAO.addWord(word)) {
            wordInput.clear();
            loadWords();
        } else {
             showAlert("Error", "Word probably exists!");
        }
    }

    @FXML
    private void onDelete() {
        String selected = wordList.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        if (dictDAO.deleteWord(selected)) {
            loadWords();
        }
    }

    @FXML
    private void onBack() throws IOException {
        Main.setRoot("main_menu");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.show();
    }
}
