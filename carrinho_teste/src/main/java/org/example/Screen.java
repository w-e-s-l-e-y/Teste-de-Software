package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame implements ActionListener {
    public Screen() {

        setVisible(true);
        setSize(800, 500);
        setTitle("aaaaa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        JButton RemoveButton = new JButton("Remover Item");
        RemoveButton.setBounds(100, 300, 250, 50);
        RemoveButton.setFont(new Font("Arial", Font.BOLD, 30));
        RemoveButton.setForeground(new Color(255, 255, 255));
        RemoveButton.setBackground(new Color(10, 10, 10));
        add(RemoveButton);


        JButton AddButton = new JButton("Adicionar Item");
        AddButton.setBounds(450, 300, 250, 50);
        AddButton.setFont(new Font("Arial", Font.BOLD, 30));
        AddButton.setForeground(new Color(255, 255, 255));
        AddButton.setBackground(new Color(10, 10, 10));
        add(AddButton);

        JButton CalcularTotal = new JButton("Calcular Total");
        CalcularTotal.setBounds(280, 400, 250, 50);
        CalcularTotal.setFont(new Font("Arial", Font.BOLD, 30));
        CalcularTotal.setForeground(new Color(255, 255, 255));
        CalcularTotal.setBackground(new Color(10, 10, 10));
        add(CalcularTotal);




        //ActionListener

        RemoveButton.addActionListener(this);
        AddButton.addActionListener(this);
        CalcularTotal.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"Item Adicionado", "...", JOptionPane.WARNING_MESSAGE);
    }
}
