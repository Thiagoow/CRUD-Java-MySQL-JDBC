package gamestore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/projetomusica";
            String user = "root";
            // String senha = "admin";
            return DriverManager.getConnection(url, user, null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }   
}
