package org.example;
import java.util.List;

public class Tabela {
    private List<Time> times;
    private List<Jogo> jogos;

    public Tabela(List<Time> times, List<Jogo> jogos) {
        this.times = times;
        this.jogos = jogos;
    }

    public Time calcularLider() {
        // Implementação para calcular o líder da tabela
    }

    public Time calcularLanterna() {
        // Implementação para calcular o lanterna da tabela
    }

    public List<Time> calcularRebaixados() {
        // Implementação para calcular os times na zona de rebaixamento
    }

    public void informarDadosTime(Time time) {
        // Implementação para informar os dados de um determinado time
    }
}
