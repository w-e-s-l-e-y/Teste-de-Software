package org.example;

class Time {
    private String nome;
    private int pontos;
    private int golsMarcados;
    private int golsSofridos;

    public Time(String nome) {
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    public void adicionarGolsMarcados(int gols) {
        this.golsMarcados += gols;
    }

    public void adicionarGolsSofridos(int gols) {
        this.golsSofridos += gols;
    }

    public int getPontos() {
        return pontos;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public int getSaldoDeGols() {
        return golsMarcados - golsSofridos;
    }

    public int calcularPontos() {
        return golsMarcados * 3 + golsSofridos;
    }
}