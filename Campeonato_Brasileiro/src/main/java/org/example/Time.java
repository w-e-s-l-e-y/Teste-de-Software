package org.example;

public class Time {
    private String nome;
    private int pontuacao;
    private int saldoGols;

    public Time(String nome, int pontuacao, int saldoGols) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.saldoGols = saldoGols;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getSaldoGols() {
        return saldoGols;
    }


    public Time() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
    }

    public void atualizarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }


    public void setId(int id) {
    }
}
