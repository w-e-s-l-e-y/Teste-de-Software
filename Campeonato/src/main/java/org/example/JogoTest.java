package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JogoTest {
    private Jogo jogo;
    private Time time1;
    private Time time2;

    @BeforeEach
    void setUp() {
        time1 = new Time("Time 1");
        time2 = new Time("Time 2");
        jogo = new Jogo(time1, time2);
    }

    @Test
    void testSetResultadoTime1Vence() {
        jogo.setResultado(2, 1);
        assertEquals(3, time1.getPontos());
        assertEquals(0, time2.getPontos());
    }

    @Test
    void testSetResultadoTime2Vence() {
        jogo.setResultado(1, 2);
        assertEquals(0, time1.getPontos());
        assertEquals(3, time2.getPontos());
    }

    @Test
    void testSetResultadoEmpate() {
        jogo.setResultado(1, 1);
        assertEquals(1, time1.getPontos());
        assertEquals(1, time2.getPontos());
    }

    @Test
    void testSetResultadoGolsMarcadosESofridos() {
        jogo.setResultado(2, 1);
        assertEquals(2, time1.getGolsMarcados());
        assertEquals(1, time1.getGolsSofridos());
        assertEquals(1, time2.getGolsMarcados());
        assertEquals(2, time2.getGolsSofridos());
    }
}