package org.example;

class Jogo {
    private Time time1;
    private Time time2;
    private int golsTime1;
    private int golsTime2;

    public Jogo(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
    }

    public void setResultado(int golsTime1, int golsTime2) {
        this.golsTime1 = golsTime1;
        this.golsTime2 = golsTime2;

        if (golsTime1 > golsTime2) {
            time1.adicionarPontos(3);
        } else if (golsTime1 < golsTime2) {
            time2.adicionarPontos(3);
        } else {
            time1.adicionarPontos(1);
            time2.adicionarPontos(1);
        }

        time1.adicionarGolsMarcados(golsTime1);
        time1.adicionarGolsSofridos(golsTime2);
        time2.adicionarGolsMarcados(golsTime2);
        time2.adicionarGolsSofridos(golsTime1);
    }
}