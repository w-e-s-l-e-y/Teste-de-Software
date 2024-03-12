package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.DefaultListModel;
import java.util.List;
import java.util.ArrayList;

public class Screen extends JFrame {

    private ShopCarrinho shopCarrinho;
    private List<CarrinhoItems> items;
    private DefaultListModel<String> listModel;
    private JList<String> itemList; // Movido para o nível de classe

    private JLabel totalPriceLabel;

    public Screen() {
        this.shopCarrinho = new ShopCarrinho();
        this.items = new ArrayList<>();
        this.listModel = new DefaultListModel<>();

        setTitle("ShopCarrinho");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.white);

        // Inicializa itemList
        itemList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(itemList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Adicionar Item");
        addButton.setFont(new Font("Arial", Font.BOLD, 20));
        addButton.setForeground(new Color(0, 0, 0));
        addButton.setBackground(new Color(119, 250, 119));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });

        JButton removeButton = new JButton("Remover Item");
        removeButton.setFont(new Font("Arial", Font.BOLD, 20));
        removeButton.setForeground(new Color(0, 0, 0));
        removeButton.setBackground(new Color(252, 112, 112));
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerItem();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        totalPriceLabel = new JLabel("Total: R$ 0.00");
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(totalPriceLabel, BorderLayout.NORTH);

        add(mainPanel);
        setVisible(true);
    }

    private void adicionarItem() {
        String nome = JOptionPane.showInputDialog("Nome do item:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do item:"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));

        CarrinhoItems item = new CarrinhoItems(nome, preco, quantidade);
        shopCarrinho.addItem(item);
        items.add(item);
        listModel.addElement(item.getNome() + " - R$" + item.getTotalPrice());

        JOptionPane.showMessageDialog(null, "Item adicionado!", "Sucesso!!", JOptionPane.WARNING_MESSAGE);

        atualizarTotal();
    }

    private void removerItem() {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
            CarrinhoItems itemRemover = items.get(selectedIndex);
            shopCarrinho.removerItem(itemRemover);
            items.remove(selectedIndex);
            listModel.remove(selectedIndex);
            JOptionPane.showMessageDialog(null, "Item removido!", "Sucesso!!", JOptionPane.WARNING_MESSAGE);
            atualizarTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para remover.");
        }
    }

    private void atualizarTotal() {
        double total = shopCarrinho.calcularTotal();
        totalPriceLabel.setText("Total: R$" + String.format("%.2f", total));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Screen();
            }
        });
    }
}
