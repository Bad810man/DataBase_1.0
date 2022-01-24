package org;

import java.sql.*;

public class DataBaseClass {

    // Data for connection to database.
    static final String DATABASE_URL = "jdbc:mysql://localhost/Students";
    static final String USER = "root";
    static final String PASSWORD = "decay13351";

    Connection connection;

    DataBaseClass () {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("OK");
        } catch (SQLException e) {
            System.out.println("FAIL");
            e.printStackTrace();
        }
    }

    // Method for close connection.
    protected void CloseConnection() throws SQLException{
        connection.close();
    }
}
