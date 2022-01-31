package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/schematest?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "qwerty123Ffd";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    public Connection conection(){

        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;

        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }

        System.out.println("Соединение не выполнено!");
        return conn;
    }


}






//