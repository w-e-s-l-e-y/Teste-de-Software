package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tabela {
    private List<Time> listaTimes;
    private List<Jogo> listaJogos;

    public Tabela() {
        this.listaTimes = new ArrayList<>();
        this.listaJogos = new ArrayList<>();
    }

    public void adicionarTime(Time time, Connection connection) throws SQLException {
        listaTimes.add(time);
        String sql = "INSERT INTO times (nome) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, time.getNome());
            statement.executeUpdate();
        }
    }

    public void adicionarJogo(Jogo jogo, Connection connection) throws SQLException {
        listaJogos.add(jogo);
        String sql = "INSERT INTO jogos (timeCasa, timeVisitante, golsCasa, golsVisitante, data) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jogo.getTimeCasa());
            statement.setString(2, jogo.getTimeVisitante());
            statement.setInt(3, jogo.getGolsCasa());
            statement.setInt(4, jogo.getGolsVisitante());
            statement.setDate(5, new java.sql.Date(jogo.getData().getTime()));
            statement.executeUpdate();
        }
    }

    public List<Time> getListaTimes() {
        return listaTimes;
    }

    public List<Jogo> getListaJogos() {
        return listaJogos;
    }
}
