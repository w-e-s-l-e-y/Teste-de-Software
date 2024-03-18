package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            if (connection != null) {
                System.out.println("Conexão com o banco de dados realizada com sucesso!");
                criarTabelas(connection);
                popularTabelas(connection);
            } else {
                System.out.println("Falha ao conectar com o banco de dados!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Feche a conexão com o banco de dados
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void criarTabelas(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            // Script SQL para criar a tabela times
            String sqlTimes = "CREATE TABLE IF NOT EXISTS times ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "nome VARCHAR(100),"
                    + "pontuacao INT DEFAULT 0,"
                    + "vitorias INT DEFAULT 0,"
                    + "empates INT DEFAULT 0,"
                    + "derrotas INT DEFAULT 0,"
                    + "saldoGols INT DEFAULT 0,"
                    + "golsMarcados INT DEFAULT 0,"
                    + "golsSofridos INT DEFAULT 0"
                    + ")";
            statement.executeUpdate(sqlTimes);

            // Script SQL para criar a tabela jogos
            String sqlJogos = "CREATE TABLE IF NOT EXISTS jogos ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "timeCasa VARCHAR(100),"
                    + "timeVisitante VARCHAR(100),"
                    + "golsCasa INT,"
                    + "golsVisitante INT,"
                    + "data DATE"
                    + ")";
            statement.executeUpdate(sqlJogos);
        }
    }

    private static void popularTabelas(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            // Script SQL para popular a tabela jogos com alguns jogos de exemplo
            String sqlPopulaJogos = "INSERT INTO jogos (timeCasa, timeVisitante, golsCasa, golsVisitante, data) VALUES " +
                    "('Flamengo', 'Palmeiras', 2, 1, '2024-03-18')," +
                    "('Atlético-MG', 'São Paulo', 1, 1, '2024-03-19')," +
                    "('Internacional', 'Grêmio', 2, 0, '2024-03-20')," +
                    "('Fluminense', 'Cruzeiro', 1, 1, '2024-03-21')," +
                    "('Botafogo', 'Atlético-PR', 0, 2, '2024-03-22')," +
                    "('Sport', 'Vitória', 2, 1, '2024-03-23')," +
                    "('Bahia', 'Santos', 1, 2, '2024-03-24')," +
                    "('Corinthians', 'Chapecoense', 3, 0, '2024-03-25')," +
                    "('Vasco', 'Ceará', 0, 1, '2024-03-26')," +
                    "('Fortaleza', 'Goias', 2, 2, '2024-03-27')," +
                    "('Juventude', 'Bragantino', 1, 3, '2024-03-28')," +
                    "('Atlético-GO', 'Ponte Preta', 0, 0, '2024-03-29')," +
                    "('CSA', 'Avaí', 2, 0, '2024-03-30')," +
                    "('Paraná', 'Náutico', 1, 1, '2024-03-31')," +
                    "('Operário-PR', 'CRB', 2, 1, '2024-04-01')," +
                    "('Londrina', 'Brusque', 0, 2, '2024-04-02')," +
                    "('Sampaio Corrêa', 'Confiança', 1, 0, '2024-04-03')," +
                    "('Remo', 'Vila Nova', 2, 2, '2024-04-04')," +
                    "('Botafogo-SP', 'Oeste', 3, 1, '2024-04-05')," +
                    "('Guarani', 'Criciúma', 1, 1, '2024-04-06')";
            statement.executeUpdate(sqlPopulaJogos);
        }
    }

}
