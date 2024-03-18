package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            // Insira a URL do seu banco de dados
            String url = "jdbc:mysql://localhost:3306/brasileirao";
            // Insira o usuário e senha do seu banco de dados
            String user = "root";
            String password = "1234567";

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
