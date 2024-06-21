package org.example.model;

import org.example.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameHistory {
    private String userName;
    private int attempts;
    private int hits;
    private int misses;

    public GameHistory(String userName, int attempts, int hits, int misses) {
        this.userName = userName;
        this.attempts = attempts;
        this.hits = hits;
        this.misses = misses;
    }

    public static void saveGameHistory(GameHistory history) {
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "INSERT INTO GameHistory (nome_usuario, tentativas, acertos, erros) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, history.getUserName());
            stmt.setInt(2, history.getAttempts());
            stmt.setInt(3, history.getHits());
            stmt.setInt(4, history.getMisses());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        return userName;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getHits() {
        return hits;
    }

    public int getMisses() {
        return misses;
    }
}
