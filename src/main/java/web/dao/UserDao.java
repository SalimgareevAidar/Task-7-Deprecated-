package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    User getUserById(int id);

    void addUser(User newUser);

    void editUser(User editUser);

    void deleteUserById(int id);
}
