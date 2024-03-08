package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JFrame {

    private List<CarrinhoItems> items;
    private JList<String> itemList;
    private DefaultListModel<String> listModel;
    private JLabel totalPriceLabel;

    public Screen() {
        this.items = new ArrayList<>();
        this.listModel = new DefaultListModel<>();

        //janela
        setTitle("ShopCarrinho");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.white);

        // Lista de itens
        itemList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(itemList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        //Designer botões
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Adicionar Item");
        addButton.setBounds(100, 300, 250, 30);
        addButton.setFont(new Font("Arial", Font.BOLD, 20));
        addButton.setForeground(new Color(0, 0, 0));
        addButton.setBackground(new Color(119, 250, 119));
        add(addButton);


        JButton removeButton = new JButton("Remover Item");
        removeButton.setBounds(100, 300, 250, 30);
        removeButton.setFont(new Font("Arial", Font.BOLD, 20));
        removeButton.setForeground(new Color(0, 0, 0));
        removeButton.setBackground(new Color(252, 112, 112));
        add(removeButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                adicionarItem();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerItem();
            }
        });
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        //  preço total
        totalPriceLabel = new JLabel("Total: R$ 0.00");
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(totalPriceLabel, BorderLayout.NORTH);


        // Adiciona o painel principal à janela
        add(mainPanel);

        // Abre a janela
        setVisible(true);
    }

    private void adicionarItem() {
        String nome = JOptionPane.showInputDialog("Nome do item:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do item:"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));

        CarrinhoItems item = new CarrinhoItems(nome, preco, quantidade);
        items.add(item);
        listModel.addElement(item.getNome() + " - R$" + item.getTotalPrice());
        JOptionPane.showMessageDialog(null, "Item adicionado!", "Sucesso!!", JOptionPane.WARNING_MESSAGE);

        atualizarTotal();
    }

    private void removerItem() {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
            items.remove(selectedIndex);
            listModel.remove(selectedIndex);
            JOptionPane.showMessageDialog(null, "Item removido!", "Sucesso!!", JOptionPane.WARNING_MESSAGE);
            atualizarTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para remover.");
        }
    }

    private void atualizarTotal() {

        double total = calcularTotal();

        totalPriceLabel.setText("Total: R$" + String.format("%.2f", total));
    }

    private double calcularTotal() {
        double total = 0;
        for (CarrinhoItems item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Screen();
            }
        });
    }
}