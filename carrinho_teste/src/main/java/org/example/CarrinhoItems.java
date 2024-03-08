package org.example;
public class CarrinhoItems {

    private String nome;
    private double preco;
    private  int quantidade;


    public CarrinhoItems(String nome, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;

    }

    public int getQuantidade(){
        return quantidade;

    }

    public double getTotalPrice(){
        return preco * quantidade;
    }

    public class LayoutParams {
    }
}
