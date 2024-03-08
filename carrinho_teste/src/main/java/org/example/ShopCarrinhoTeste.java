package org.example;
import org.junit.Before;
import org.junit.Test;
import  static org.junit.Assert.*;

public class ShopCarrinhoTeste {

    private ShopCarrinho carrinho;

    @Before
    public void setUp(){
        carrinho = new ShopCarrinho();
    }

    @Test
    public void testeAddItem(){
        CarrinhoItems item = new CarrinhoItems("Notebook",1000.00,1);
        carrinho.addItem(item);
        assertEquals(1000.00,carrinho.calcularTotal(), 0.01);

    }

    @Test
    public void testeRemoveItem(){
        CarrinhoItems item = new CarrinhoItems("Notebook", 1000.00, 1);
        carrinho.addItem(item);
        carrinho.removerItem(item);
        assertEquals(0,carrinho.calcularTotal(),0.01);
    }

    @Test
    public void testeCalcularTotal(){
        CarrinhoItems item1 = new CarrinhoItems("Notebook", 1000.00, 1);
        CarrinhoItems item2 = new CarrinhoItems("Celular", 500.00, 2);
        carrinho.addItem(item1);
        carrinho.addItem(item2);
        assertEquals(2000, carrinho.calcularTotal(), 0.01);
    }
}
