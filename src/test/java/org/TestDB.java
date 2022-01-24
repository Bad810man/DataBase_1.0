package org;

import java.sql.SQLException;
import java.util.Scanner;

public class TestDB {
    public static void main(String[] args) {
        DataBaseClass dataBase = new DataBaseClass();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер пукта меню:");
        System.out.println("1. Посмотреть все записи");
        System.out.println("2. Посмотреть записи конкретной группы");
        System.out.println("3. Посмотреть информацию о конкретном студенте");
        System.out.println("0. Выход");

        String in = scanner.nextLine();
        switch (in) {
            case "1":
                dataBase.showAllRecords();
                break;
            case "2":
                System.out.println("Введите номер группы:");
                String gr = scanner.nextLine();
                dataBase.showCertainGroup(gr);
                break;
            case "3":
                System.out.println("Введите номер студенческого билета:");
                String studentBook = scanner.nextLine();
                dataBase.showCertainStudent(studentBook);
                break;
            case "0":
                try {
                    dataBase.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
