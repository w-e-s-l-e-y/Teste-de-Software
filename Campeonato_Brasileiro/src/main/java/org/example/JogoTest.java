package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class JogoTest {

    @Test
    public void testCriarJogoEntreTimes() {
        Time palmeiras = new Time("Palmeiras", 10, 5);
        Time flamengo = new Time("Flamengo", 8, 3);
        Jogo jogo = new Jogo(palmeiras, flamengo);
        assertNotNull(jogo);
    }

    @Test
    public void testRegistrarResultadoDoJogo() {
        Time palmeiras = new Time("Palmeiras", 10, 5);
        Time flamengo = new Time("Flamengo", 8, 3);
        Jogo jogo = new Jogo(palmeiras, flamengo);
        jogo.setResultado("3x2");
        assertEquals("3x2", jogo.getResultado());
    }
}


