package org.example.parcialfinalpoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConection {

    private static final String URL = "jdbc:sqlserver://LAPTOP-SJG098E7:)\\MSSQLSERVER16:1433;databaseName=BancoBCN2024;integratedSecurity=true;encrypt=false;";
    private static Connection connection = null;

    private BDConection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
  }
}
}