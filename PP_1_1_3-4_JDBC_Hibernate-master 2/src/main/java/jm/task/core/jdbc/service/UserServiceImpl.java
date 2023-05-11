package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    /*UserServiceImpl - внутри класса создаём экземпляр
    UserDaoJDBCImpl (дальше сообразите что делать, идея поможет)))*/
    UserDao userDao = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> list = userDao.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }
        return list;
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
