package org.example;

import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class JogoTest {

    @Test
    public void testCriarJogoComInformacoes() {
        int id = 1;
        String timeCasa = "Flamengo";
        String timeVisitante = "Fluminense";
        int golsCasa = 2;
        int golsVisitante = 1;
        Date data = new Date();

        Jogo jogo = new Jogo(id, timeCasa, timeVisitante, golsCasa, golsVisitante, data);

        assertEquals(id, jogo.getId());
        assertEquals(timeCasa, jogo.getTimeCasa());
        assertEquals(timeVisitante, jogo.getTimeVisitante());
        assertEquals(golsCasa, jogo.getGolsCasa());
        assertEquals(golsVisitante, jogo.getGolsVisitante());
        assertEquals(data, jogo.getData());
    }

    @Test
    public void testToString() {
        int id = 1;
        String timeCasa = "Flamengo";
        String timeVisitante = "Fluminense";
        int golsCasa = 2;
        int golsVisitante = 1;
        Date data = new Date();

        Jogo jogo = new Jogo(id, timeCasa, timeVisitante, golsCasa, golsVisitante, data);

        String expected = "Jogo{id=1, timeCasa='Flamengo', timeVisitante='Fluminense', golsCasa=2, golsVisitante=1, data=" + data + '}';
        assertEquals(expected, jogo.toString());
    }
}
