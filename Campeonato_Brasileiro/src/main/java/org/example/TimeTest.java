package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTest {

    @Test
    public void testCriarTimeComInformacoes() {
        Time time = new Time("Palmeiras", 10, 5);
        assertEquals("Palmeiras", time.getNome());
        assertEquals(10, time.getPontuacao());
        assertEquals(5, time.getSaldoGols());
    }

    @Test
    public void testAtualizarPontuacaoAposJogo() {
        Time time = new Time("Palmeiras", 10, 5);
        time.atualizarPontuacao(3); // Simulando vitória
        assertEquals(13, time.getPontuacao());
    }
}

