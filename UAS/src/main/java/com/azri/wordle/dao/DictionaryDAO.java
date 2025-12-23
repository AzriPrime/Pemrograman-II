package com.azri.wordle.dao;

import com.azri.wordle.util.DatabaseHandler;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDAO {

    private static List<String> cachedWords;

    public String getRandomWord(java.util.Set<String> excluded) {
        if (cachedWords == null) {
            cachedWords = getAllWords();
        }

        List<String> available = new ArrayList<>(cachedWords);

        // Client-side filtering
        if (excluded != null && !excluded.isEmpty()) {
            available.removeAll(excluded);
        }

        if (available.isEmpty()) {
            return "HABIS";
        }

        java.util.Random rand = new java.util.Random();
        return available.get(rand.nextInt(available.size()));
    }

    // Legacy overload
    public String getRandomWord() {
        return getRandomWord(null);
    }

    public boolean addWord(String word) {
        if (word == null || word.length() != 5)
            return false;
        String query = "INSERT INTO words (word) VALUES (?)";
        try (Connection conn = DatabaseHandler.getInstance().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, word.toUpperCase());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Likely duplicate
            return false;
        }
    }

    public boolean deleteWord(String word) {
        String query = "DELETE FROM words WHERE word = ?";
        try (Connection conn = DatabaseHandler.getInstance().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, word);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getAllWords() {
        List<String> words = new ArrayList<>();
        String query = "SELECT word FROM words ORDER BY word ASC";
        try (Connection conn = DatabaseHandler.getInstance().getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                words.add(rs.getString("word"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return words;
    }
}
