package org.example;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TabelaTest {

    @Test
    public void testCalcularLiderDaTabela() {
        // Criar uma tabela com times e pontuações conhecidas
        List<Time> times = List.of(
                new Time("Time A", 15, 10),
                new Time("Time B", 12, 8),
                new Time("Time C", 10, 5)
        );
        Tabela tabela = new Tabela(times);

        // Verificar se o líder é calculado corretamente
        Time lider = tabela.getLider();
        assertEquals("Time A", lider.getNome());
    }

    @Test
    public void testCalcularLanternaDaTabela() {
        // Criar uma tabela com times e pontuações conhecidas
        List<Time> times = List.of(
                new Time("Time A", 15, 10),
                new Time("Time B", 12, 8),
                new Time("Time C", 10, 5)
        );
        Tabela tabela = new Tabela(times);

        // Verificar se o lanterna é calculado corretamente
        Time lanterna = tabela.getLanterna();
        assertEquals("Time C", lanterna.getNome());
    }

    @Test
    public void testIdentificarTimesNaZonaDeRebaixamento() {
        // Criar uma tabela com times e pontuações conhecidas
        List<Time> times = List.of(
                new Time("Time A", 15, 10),
                new Time("Time B", 12, 8),
                new Time("Time C", 10, 5),
                new Time("Time D", 8, 3),
                new Time("Time E", 5, -5)
        );
        Tabela tabela = new Tabela(times);

        // Verificar se os times na zona de rebaixamento são identificados corretamente
        List<Time> rebaixados = tabela.getTimesNaZonaDeRebaixamento();
        assertEquals(3, rebaixados.size());
        assertTrue(rebaixados.contains(new Time("Time C", 10, 5)));
        assertTrue(rebaixados.contains(new Time("Time D", 8, 3)));
        assertTrue(rebaixados.contains(new Time("Time E", 5, -5)));
    }

    @Test
    public void testObterDadosDoTime() {
        // Criar uma tabela com times e pontuações conhecidas
        List<Time> times = List.of(
                new Time("Time A", 15, 10),
                new Time("Time B", 12, 8),
                new Time("Time C", 10, 5)
        );
        Tabela tabela = new Tabela(times);

        // Verificar se é possível obter informações detalhadas de um time específico
        Time time = tabela.getTime("Time B");
        assertNotNull(time);
        assertEquals("Time B", time.getNome());
        assertEquals(12, time.getPontuacao());
        assertEquals(8, time.getSaldoGols());
    }
}

