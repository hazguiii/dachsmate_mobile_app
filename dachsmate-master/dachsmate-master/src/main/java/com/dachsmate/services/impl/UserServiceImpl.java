package com.dachsmate.services.impl;

import com.dachsmate.dao.UserDao;
import com.dachsmate.entity.User;
import com.dachsmate.services.UserService;
import com.dachsmate.views.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
 
    @Override
    public User findUserForLoginPassword(String username, String userPassword) {

        return userDao.findForLoginPassword(username, userPassword);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public User saveUser(UserView userView) {
        return userDao.save(User.newInstance(userView));
    }

    @Override
    public User updateUser(User user, UserView userView) {

        user.setUserPassword(userView.getUserPassword());
        user.setUsername(userView.getUsername());
        user.setUseremail(userView.getUseremail());
        user.setVehicleId(userView.getVehicleId());

        userDao.saveAndFlush(user);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public String deleteUser(User user) {
        userDao.delete(user);
        return "ok";
    }
}
