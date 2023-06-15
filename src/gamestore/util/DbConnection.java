package gamestore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/gamestore";
            String dbUserLogin = "root";
            String dbUserPassword = "root";
            return DriverManager.getConnection(dbUrl, dbUserLogin, dbUserPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
