package org.example;
import java.util.ArrayList;
import java.util.List;



public class ShopCarrinho {

       private List<CarrinhoItems> items;

    public ShopCarrinho(){
        this.items = new ArrayList<>();

    }

    public void addItem(CarrinhoItems item){
        items.add(item);
    }

    public void  removerItem(CarrinhoItems item){
        items.remove(item);
    }

    public double calcularTotal(){
        double total = 0;
        for (CarrinhoItems item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
