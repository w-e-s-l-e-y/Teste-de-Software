package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tabela {
    private List<Time> times;
    private List<Jogo> jogos;

    public Tabela(List<Time> times, List<Jogo> jogos) {
        this.times = times;
        this.jogos = jogos;
    }

    public Tabela(List<Time> times) {
        this.times = times;
    }

    public Time calcularLider() {
        Time lider = null;
        int maiorPontuacao = Integer.MIN_VALUE;

        for (Time time : times) {
            if (time.getPontuacao() > maiorPontuacao) {
                lider = time;
                maiorPontuacao = time.getPontuacao();
            }
        }

        return lider;
    }

    public Time calcularLanterna() {
        Time lanterna = null;
        int menorPontuacao = Integer.MAX_VALUE;

        for (Time time : times) {
            if (time.getPontuacao() < menorPontuacao) {
                lanterna = time;
                menorPontuacao = time.getPontuacao();
            }
        }

        return lanterna;
    }

    public List<Time> getTimesNaZonaDeRebaixamento() {
        List<Time> timesNaZonaDeRebaixamento = new ArrayList<>();
        int menorPontuacao = Integer.MAX_VALUE;

        // Encontrar a menor pontuação entre os times
        for (Time time : times) {
            if (time.getPontuacao() < menorPontuacao) {
                menorPontuacao = time.getPontuacao();
            }
        }

        // Adicionar os times com essa pontuação mínima à lista de times na zona de rebaixamento
        for (Time time : times) {
            if (time.getPontuacao() == menorPontuacao) {
                timesNaZonaDeRebaixamento.add(time);
            }
        }

        return timesNaZonaDeRebaixamento;
    }
    private int calcularPontuacaoMaxima() {
        int maxPontuacao = Integer.MIN_VALUE;
        for (Time time : times) {
            if (time.getPontuacao() > maxPontuacao) {
                maxPontuacao = time.getPontuacao();
            }
        }
        return maxPontuacao;
    }
    public Time getTime(String nome) {
        for (Time time : times) {
            if (time.getNome().equals(nome)) {
                return time;
            }
        }
        return null;
    }

    public Time getLider() {
        Time lider = null;
        int maiorPontuacao = Integer.MIN_VALUE;

        for (Time time : times) {
            if (time.getPontuacao() > maiorPontuacao) {
                lider = time;
                maiorPontuacao = time.getPontuacao();
            }
        }

        return lider;
    }

    public Time getLanterna() {
        Time lanterna = null;
        int menorPontuacao = Integer.MAX_VALUE;

        for (Time time : times) {
            if (time.getPontuacao() < menorPontuacao) {
                lanterna = time;
                menorPontuacao = time.getPontuacao();
            }
        }

        return lanterna;
    }
}
