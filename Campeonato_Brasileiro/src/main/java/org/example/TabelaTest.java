package org.example;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TabelaTest {

    @Test
    public void testAdicionarTime() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        assertNotNull(connection);

        Tabela tabela = new Tabela();
        Time time = new Time(1, "Flamengo");
        tabela.adicionarTime(time, connection); // Passando também a conexão

        assertEquals(1, tabela.getListaTimes().size());
        assertEquals("Flamengo", tabela.getListaTimes().get(0).getNome());
    }

    @Test
    public void testAdicionarJogo() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        assertNotNull(connection);

        Tabela tabela = new Tabela();

        Date dataJogo = new Date(0);
        Jogo jogo = new Jogo(1, "Flamengo", "Corinthians", 2, 1, dataJogo);
        tabela.adicionarJogo(jogo, connection); // Passando também a conexão

        // Verifica se o jogo foi adicionado corretamente
        assertEquals(1, tabela.getListaJogos().size());
        assertEquals("Flamengo", tabela.getListaJogos().get(0).getTimeCasa());
        assertEquals("Corinthians", tabela.getListaJogos().get(0).getTimeVisitante());
        assertEquals(2, tabela.getListaJogos().get(0).getGolsCasa());
        assertEquals(1, tabela.getListaJogos().get(0).getGolsVisitante());

        // Fechar a conexão após o teste
        connection.close();
    }

}