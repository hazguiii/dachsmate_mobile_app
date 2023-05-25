package com.dachsmate.services;

import com.dachsmate.entity.User;
import com.dachsmate.views.UserView;

import java.util.List;

public interface UserService {

    User findUserForLoginPassword(String username, String userPassword);

    User findUserById(Integer id);

    User saveUser(UserView userView);

    User updateUser(User user, UserView userView);

    String deleteUser(User user);

    List<User> findAllUsers();
}
