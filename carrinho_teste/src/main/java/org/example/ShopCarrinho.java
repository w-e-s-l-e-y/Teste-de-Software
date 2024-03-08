package org.example;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class ShopCarrinho {


    public static void main (String[] args){
        new Screen();


    }

       private List<CarrinhoItems> items;

    public ShopCarrinho(){
        this.items = new ArrayList<>();



    }


    public void addItem(CarrinhoItems item){
        items.add(item);
    }

    public void  removerItem(CarrinhoItems item){
        items.remove(item);
        JOptionPane.showInputDialog(item);
    }



    public double calcularTotal(){
        double total = 0;
        for (CarrinhoItems item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }


}
