package com.company.sqlite;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {

    static String dbPath = "jdbc:sqlite:/Users/atatarkanov/sqllite/bank.db";
    public static String getDbPath() {
        return dbPath;
    }

    public static Connection getConnection () {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(dbPath);
        }
        catch (SQLException | ClassNotFoundException throwables) {
            System.out.println("No connection");
        }
        return conn;
    }

    public static void closeConnection(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                System.out.println("Connection error");
            }
        }
    }

}