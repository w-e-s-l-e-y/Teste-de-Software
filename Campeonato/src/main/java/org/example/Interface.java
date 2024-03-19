package org.example;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Interface extends JFrame {
    private JTable timesTable;
    private JTable jogosTable;
    private JLabel liderLabel;
    private JLabel lanternaLabel;
    private JLabel rebaixadosLabel;

    public Interface() {
        setTitle("Campeonato Brasileiro");

        // Criar tabela para os times
        timesTable = new JTable();
        JScrollPane timesScrollPane = new JScrollPane(timesTable);
        timesScrollPane.setBorder(BorderFactory.createTitledBorder("Times"));


        // Criar tabela para os jogos
        jogosTable = new JTable();
        JScrollPane jogosScrollPane = new JScrollPane(jogosTable);
        jogosScrollPane.setBorder(BorderFactory.createTitledBorder("Jogos"));

        // Labels para exibir informações sobre o líder, lanterna e times rebaixados
        liderLabel = new JLabel("Líder: ");
        lanternaLabel = new JLabel("Lanterna: ");
        rebaixadosLabel = new JLabel("Times Rebaixados: ");

        // Layout
        setLayout(new BorderLayout());
        JPanel tabelasPanel = new JPanel(new GridLayout(2, 1));
        tabelasPanel.add(timesScrollPane);
        tabelasPanel.add(jogosScrollPane);
        add(tabelasPanel, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        infoPanel.add(liderLabel);
        infoPanel.add(lanternaLabel);
        infoPanel.add(rebaixadosLabel);
        add(infoPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void carregarDados() {
        // Carregar dados da tabela "times"
        DefaultTableModel timesModel = new DefaultTableModel();
        timesModel.addColumn("Times");
        timesTable.setModel(timesModel);



        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:campeonato.db");
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM times");
            while (rs.next()) {
                String nome = rs.getString("nome");
                timesModel.addRow(new Object[]{nome});
            }
            timesTable.setModel(timesModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os times: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // Carregar dados da tabela "jogos"
        DefaultTableModel jogosModel = new DefaultTableModel();
        jogosModel.addColumn("Time 1");
        jogosModel.addColumn("Time 2");
        jogosModel.addColumn("Gols Time 1");
        jogosModel.addColumn("Gols Time 2");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:campeonato.db");
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM jogos");
            while (rs.next()) {
                String time1 = rs.getString("time1");
                String time2 = rs.getString("time2");
                int golsTime1 = rs.getInt("golsTime1");
                int golsTime2 = rs.getInt("golsTime2");
                jogosModel.addRow(new Object[]{time1, time2, golsTime1, golsTime2});
            }
            jogosTable.setModel(jogosModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os jogos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // Carregar informações sobre o líder, lanterna e times rebaixados
        List<Time> times = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:campeonato.db");
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM times");
            while (rs.next()) {
                String nome = rs.getString("nome");
                Time time = new Time(nome);
                times.add(time);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os times: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        Tabela tabela = new Tabela(times);
        Time lider = tabela.getLider();
        Time lanterna = tabela.getLanterna();
        List<Time> rebaixados = tabela.getTimesRebaixados();

        liderLabel.setText("Líder: " + (lider != null ? lider.getNome() : "Nenhum"));
        lanternaLabel.setText("Lanterna: " + (lanterna != null ? lanterna.getNome() : "Nenhum"));


        StringBuilder rebaixadosText = new StringBuilder("Times Rebaixados: ");
        for (int i = 0; i < rebaixados.size(); i++) {
            rebaixadosText.append(rebaixados.get(i).getNome());
            if (i < rebaixados.size() - 1) {
                rebaixadosText.append(", ");
            }
        }
        rebaixadosLabel.setText(rebaixadosText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           Interface campeonatoInterface = new Interface();
            campeonatoInterface.setVisible(true);
            campeonatoInterface.carregarDados();
        });
    }
}