package org.example;
import java.util.List;

public class Tabela {
    private List<Time> times;
    private List<Jogo> jogos;

    public Tabela(List<Time> times, List<Jogo> jogos) {
        this.times = times;
        this.jogos = jogos;
    }

    public Tabela(List<Time> times) {
    }

    public Time calcularLider() {
        // Implementação para calcular o líder da tabela
        return null;
    }

    public Time calcularLanterna() {
        // Implementação para calcular o lanterna da tabela
        return null;
    }

    public List<Time> calcularRebaixados() {
        // Implementação para calcular os times na zona de rebaixamento
        return null;
    }

    public void informarDadosTime(Time time) {
        // Implementação para informar os dados de um determinado time
    }

    public Time getLider() {
        return null;
    }

    public Time getLanterna() {
        return null;
    }

    public List<Time> getTimesNaZonaDeRebaixamento() {
        return null;
    }

    public Time getTime(String timeB) {
        return null;
    }
}
