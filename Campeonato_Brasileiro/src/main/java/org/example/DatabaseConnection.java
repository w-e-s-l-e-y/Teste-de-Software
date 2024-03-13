package org.example;

javaCopy code
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeRepository {
    public void save(Time time) {
        String sql = "INSERT INTO Time (nome, pontuacao, saldo_gols) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, time.getNome());
            pstmt.setInt(2, time.getPontuacao());
            pstmt.setInt(3, time.getSaldoGols());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Time> findAll() {
        String sql = "SELECT * FROM Time";
        List<Time> times = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Time time = new Time();
                time.setId(rs.getInt("id"));
                time.setNome(rs.getString("nome"));
                time.setPontuacao(rs.getInt("pontuacao"));
                time.setSaldoGols(rs.getInt("saldo_gols"));
                times.add(time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return times;
    }
}


