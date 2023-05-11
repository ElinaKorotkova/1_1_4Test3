package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    //  Util util = getUtil();

    //DELETE FROM customers;
    //TRUNCATE TABLE customers;
    //TRUNCATE TABLE best.products;
    private static final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    //создать таблицу пользователей
    public void createUsersTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, lastname VARCHAR(20) NOT NULL, age INT NOT NULL)")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //CREATE TABLE Persons (
    //    Personid int NOT NULL AUTO_INCREMENT,
    //    LastName varchar(255) NOT NULL,
    //    FirstName varchar(255),
    //    Age int,
    //    PRIMARY KEY (Personid)
    //);
    //CREATE TABLE IF NOT EXISTS User (
    //    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    //    NAME CHARACTER(200),
    //    LASTNAME CHARACTER(200),
    //    Age INTEGER
    //);

    //удалить таблицу пользователей
    public void dropUsersTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS users")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //  PreparedStatement pstmt = con.prepareStatement("UPDATE EMPLOYEES
//SET SALARY = ? WHERE ID = ?");
    //pstmt.setBigDecimal(1, 153833.00)
//pstmt.setInt(2, 110592)

    //добавить пользотелей
    /*public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO users (name, last_Name, age) VALUES ('name', desc)");
            *//*statement.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setByte(3, age);
            pstmt.executeUpdate();*//*
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
 /*st.setString(1, name);
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //удалить пользователя по id
    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //получить всех пользователей
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT id, name, lastname, age FROM users";
        try (Statement st = Util.getConnection().createStatement();) {
            ResultSet resultSet = st.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                //   user.setId(resultSet.getLong(1));
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
//return "ID" + id + "NAME" + name + "LASTNAME" + lastName + "AGE" + age;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    //очистить таблицу пользователей
    public void cleanUsersTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/* try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?")) {
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();*/
/*try (Statement st = connection.createStatement()) {
        st.executeUpdate("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
        e.printStackTrace();
        }*/










