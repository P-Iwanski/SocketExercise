package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static String DB_URL = "jdbc:mysql://localhost:3306/%s?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static String DB_USER = "root";
    private static String DB_PASS = "coderslab";

    public static Connection connect() throws SQLException {
        return connect("RecruitmentExercise");
    }

    public static Connection connect(String databaseName) throws SQLException {
        String url = String.format(DB_URL, databaseName);
        Connection conn = DriverManager.getConnection(url, DB_USER, DB_PASS);
        return conn;
    }
}