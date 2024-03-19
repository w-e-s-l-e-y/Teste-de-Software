package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TabelaTest {

    @Test
    void testLider() {
        List<Time> times = new ArrayList<>();
        Time time1 = new Time("Time 1");
        time1.adicionarPontos(10);
        Time time2 = new Time("Time 2");
        time2.adicionarPontos(15);
        times.add(time1);
        times.add(time2);

        Tabela tabela = new Tabela(times);
        assertEquals(time2, tabela.getLider());
    }

    @Test
    void testLanterna() {
        List<Time> times = new ArrayList<>();
        Time time1 = new Time("Time 1");
        time1.adicionarPontos(10);
        Time time2 = new Time("Time 2");
        time2.adicionarPontos(5);
        times.add(time1);
        times.add(time2);

        Tabela tabela = new Tabela(times);
        assertEquals(time2, tabela.getLanterna());
    }



    @Test
    void testTimesRebaixados() {
        List<Time> times = new ArrayList<>();
        Tabela tabela = new Tabela(times);
        List<Time> timesRebaixados = tabela.getTimesRebaixados();
        assertTrue(timesRebaixados.isEmpty());
    }

    @Test
    void testTime() {
        List<Time> times = new ArrayList<>();
        Time time1 = new Time("Time 1");
        Time time2 = new Time("Time 2");
        Time time3 = new Time("Time 3");
        times.add(time1);
        times.add(time2);
        times.add(time3);

        Tabela tabela = new Tabela(times);
        assertEquals(time2, tabela.getTime("Time 2"));
    }

}