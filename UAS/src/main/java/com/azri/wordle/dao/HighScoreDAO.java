package com.azri.wordle.dao;

import com.azri.wordle.util.DatabaseHandler;
import com.azri.wordle.model.HighScore;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// DAO Class
public class HighScoreDAO {
    
    public void saveScore(int score) {
        String query = "INSERT INTO high_scores (score) VALUES (?)";
        try (Connection conn = DatabaseHandler.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, score);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<HighScore> getTopScores() {
        List<HighScore> scores = new ArrayList<>();
        String query = "SELECT * FROM high_scores ORDER BY score DESC LIMIT 10";
        try (Connection conn = DatabaseHandler.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                scores.add(new HighScore(
                    rs.getInt("id"),
                    rs.getInt("score"),
                    rs.getTimestamp("achieved_at").toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }
}
