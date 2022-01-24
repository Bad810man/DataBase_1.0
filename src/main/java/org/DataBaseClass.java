package org;

import java.sql.*;

public class DataBaseClass {

    // Data for connection to database.
    static final String DATABASE_URL = "jdbc:mysql://localhost/Students";
    static final String USER = "root";
    static final String PASSWORD = "decay13351";

    protected static Connection connection;

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
    protected void closeConnection() throws SQLException{
        connection.close();
    }

    // Method for show all records in database
    protected void showAllRecords() {
        String showAll = "SELECT * FROM Students";
        showInfo(showAll);
    }

    // Method for show info about certain group
    protected void showCertainGroup(String groupN) {
        String certainGroup = "SELECT * FROM Students WHERE Группа = '" + groupN + "';";
        showInfo(certainGroup);
    }

    // Method for show info about certain student
    protected void showCertainStudent(String student) {
        String certainStudent = "SELECT * FROM Students WHERE Студенческий билет = '" + student + "';";
        showInfo(certainStudent);
    }

    private static void showInfo(String sql) {
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String lastName = rs.getString("Фамилия");
                String firstName = rs.getString("Имя");
                String middleName = rs.getString("Отчество");
                Date birthDate = rs.getDate("Дата рождения");
                String group = rs.getString("Группа");
                String studentBook = rs.getString("Студенческий билет");
                String recordBook = rs.getString("Зачетная книжка");
                System.out.println("\n==============");
                System.out.println("Фамилия: " + lastName);
                System.out.println("Имя: " + firstName);
                System.out.println("Отчество: " + middleName);
                System.out.println("Дата рождения: " + birthDate);
                System.out.println("Группа: " + group);
                System.out.println("Студенческий билет №: " + studentBook);
                System.out.println("Зачетная книжка №: " + recordBook);
                System.out.println("==============\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
