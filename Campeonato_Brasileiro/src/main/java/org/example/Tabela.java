package org.example;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        // Ordena os times pelo critério de desempate (pontuação, saldo de gols)
        List<Time> timesOrdenados = times.stream()
                .sorted(Comparator.comparingInt(Time::getPontuacao)
                        .thenComparingInt(Time::getSaldoGols))
                .collect(Collectors.toList());

        // Retorna os três primeiros times da lista ordenada
        return timesOrdenados.subList(0, Math.min(3, timesOrdenados.size()));
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
