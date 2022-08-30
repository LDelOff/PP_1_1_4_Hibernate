package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // Тут настройки подключения
    public static final String url = "jdbc:mysql://localhost:3306/pp_1_1_3-4_jdbc_hibernate";
    public static final String user = "root";
    public static final String pass = "3Iehegf@be";
    public static Connection connection2database; // Это будет объект коннекшн

    public static Connection getConnection() {
        // попытались инициализировать драйвер
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection2database = DriverManager.getConnection(url,user,pass); // Тут я подключился к БД
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection2database;
    }
}
