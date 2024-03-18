package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

public class TimeTest {

    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        connection = ConnectionFactory.getConnection();
        limparBancoDeDados();
    }

    @After
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testAdicionarTime() throws SQLException {
        Tabela tabela = new Tabela();
        Time time = new Time(1, "Flamengo");

        tabela.adicionarTime(time, connection);

        // Se necessário, faça alguma lógica de verificação para garantir que o time foi adicionado corretamente ao banco de dados
    }

    @Test
    public void testAdicionarJogo() throws SQLException {
        Tabela tabela = new Tabela();
        Jogo jogo = new Jogo(1, "Flamengo", "Corinthians", 2, 1, null);

        tabela.adicionarJogo(jogo, connection);

        // Se necessário, faça alguma lógica de verificação para garantir que o jogo foi adicionado corretamente ao banco de dados
    }

    private void limparBancoDeDados() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM times");
            statement.executeUpdate("DELETE FROM jogos");
        }
    }
}
