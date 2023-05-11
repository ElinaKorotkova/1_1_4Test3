package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {


    //private static Connection connection = null;
    // private static Util util;


    /* Connection connection;
    try {
          Driver driver = new FabricMySQLDriver();
          DriverManager.registerDriver(driver);
      }catch (SQLException e) {
          e.printStackTrace();
      }*/
    //      Connection connection = null;
    private static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static String USER = "root";
    private static String PASSWORD = "elina2305";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("OK");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("error SQLException ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
    /*public static Util getUtil() {
        if (util == null) {
            util = new Util();
        } *//*else {
            return util;
        }*//*
        return util;
    }*/


 /*   public void getConnection2() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("good");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }*/

// реализуйте настройку соеденения с БД

/* Util - подключаем нашу БД (тут самое лёгкое "почти")*/