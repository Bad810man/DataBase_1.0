package org;

import java.sql.SQLException;
import java.util.Scanner;

public class TestDB {
    public static void main(String[] args) {
        DataBaseClass connect = new DataBaseClass();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер пукта меню:");
        System.out.println("1. Добавить запись");
        System.out.println("2. Добавить запись");
        System.out.println("3. Вывести данные о студенте");
        System.out.println("0. Выход");

        String in = scanner.nextLine();
        switch (in) {
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
            case "3":
                System.out.println("Введите номер студенческого билета:");
                String studentBook = scanner.nextLine();
                // searchStudent(studentBook);
                break;
            case "0":
                try {
                    connect.CloseConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
