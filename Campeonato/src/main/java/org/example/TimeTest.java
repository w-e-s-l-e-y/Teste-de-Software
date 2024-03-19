package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @Test
    void testConstrutor() {
        Time time = new Time("Time 1");
        assertEquals("Time 1", time.getNome());
        assertEquals(0, time.getPontos());
        assertEquals(0, time.getGolsMarcados());
        assertEquals(0, time.getGolsSofridos());
    }

    @Test
    void testAdicionarPontos() {
        Time time = new Time("Time 1");
        time.adicionarPontos(3);
        assertEquals(3, time.getPontos());
    }

    @Test
    void testAdicionarGolsMarcados() {
        Time time = new Time("Time 1");
        time.adicionarGolsMarcados(2);
        assertEquals(2, time.getGolsMarcados());
    }

    @Test
    void testAdicionarGolsSofridos() {
        Time time = new Time("Time 1");
        time.adicionarGolsSofridos(1);
        assertEquals(1, time.getGolsSofridos());
    }

    @Test
    void testGetSaldoDeGols() {
        Time time = new Time("Time 1");
        time.adicionarGolsMarcados(4);
        time.adicionarGolsSofridos(2);
        assertEquals(2, time.getSaldoDeGols());
    }
}