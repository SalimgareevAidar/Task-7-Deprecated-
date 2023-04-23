package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(User newUser){
        userDao.addUser(newUser);
    }

    @Override
    public void editUser(User editUser) { userDao.editUser(editUser);}

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
}
