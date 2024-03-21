package org.example;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    private static final String URL = "jdbc:sqlite:campeonato.db";

    public static void main(String[] args) {
        Interface campeonatoInterface = new Interface();
        campeonatoInterface.setVisible(true);
        List<Time> times = new ArrayList<>();

        try {
            // Conexão com o banco de dados
            try (Connection connection = DriverManager.getConnection(URL);
                 Statement statement = connection.createStatement()) {
                // Criar a tabela de times se não existir
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS times (nome TEXT PRIMARY KEY)");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS jogos (time1 TEXT, time2 TEXT, golsTime1 INTEGER, golsTime2 INTEGER)");


                //statement.executeUpdate("INSERT INTO jogos (time1, time2, golsTime1, golsTime2) VALUES ('Atletico Mineiro', 'Flamengo', 0, 0)");
                //statement.executeUpdate("INSERT INTO jogos (time1, time2, golsTime1, golsTime2) VALUES ('Vasco', 'Flamengo', 0, 2)");
               // statement.executeUpdate("INSERT INTO jogos (time1, time2, golsTime1, golsTime2) VALUES ('São Paulo', 'Cruzeiro', 4, 2)");
               // statement.executeUpdate("INSERT INTO jogos (time1, time2, golsTime1, golsTime2) VALUES ('Santos', 'Botafogo', 1, 0)");
               // statement.executeUpdate("INSERT INTO jogos (time1, time2, golsTime1, golsTime2) VALUES ('Fluminense', 'Gremio', 0, 2)");

                // Buscar os times no banco de dados
                ResultSet rsTimes = statement.executeQuery("SELECT * FROM times");
                while (rsTimes.next()) {
                    String nomeTime = rsTimes.getString("nome");
                    Time time = new Time(nomeTime);
                    times.add(time);
                }

                // Buscar os jogos no banco de dados
                ResultSet rsJogos = statement.executeQuery("SELECT * FROM jogos");
                while (rsJogos.next()) {
                    String nomeTime1 = rsJogos.getString("time1");
                    String nomeTime2 = rsJogos.getString("time2");
                    int golsTime1 = rsJogos.getInt("golsTime1");
                    int golsTime2 = rsJogos.getInt("golsTime2");

                    Time time1 = times.stream().filter(time -> time.getNome().equals(nomeTime1)).findFirst().orElse(null);
                    Time time2 = times.stream().filter(time -> time.getNome().equals(nomeTime2)).findFirst().orElse(null);

                    if (time1 != null && time2 != null) {
                        Jogo jogo = new Jogo(time1, time2);
                        jogo.setResultado(golsTime1, golsTime2);
                    }
                }
            }


            Tabela tabela = new Tabela(times);


            Time lider = tabela.getLider();
            if (lider != null) {
                System.out.println("Líder: " + lider.getNome());
            } else {
                System.out.println("Nenhum time encontrado na tabela.");
            }


            Time lanterna = tabela.getLanterna();
            if (lanterna != null) {
                System.out.println("Lanterna: " + lanterna.getNome());
            } else {
                System.out.println("Nenhum time encontrado na tabela.");
            }


            List<Time> timesRebaixados = tabela.getTimesRebaixados();
            if (!timesRebaixados.isEmpty()) {
                System.out.println("Times rebaixados: " + timesRebaixados.stream().map(Time::getNome).collect(Collectors.toList()));
            } else {
                System.out.println("Nenhum time encontrado na tabela.");
            }


            Time Flamengo = tabela.getTime("Flamengo");
           if (Flamengo != null) {
             System.out.println("Dados do Flamengo: Pontos : " + Flamengo.getPontos() + ", Saldo de Gols : " + Flamengo.getSaldoDeGols());
           } else {
             System.out.println("Flamengo não encontrado na tabela.");
          }

           campeonatoInterface.carregarDados(lider, lanterna, timesRebaixados);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou manipular o banco de dados: " + e.getMessage());
        }

    }
}