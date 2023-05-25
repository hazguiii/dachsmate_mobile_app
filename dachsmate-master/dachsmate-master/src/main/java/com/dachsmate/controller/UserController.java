package com.dachsmate.controller;

import com.dachsmate.entity.User;
import com.dachsmate.services.UserService;
import com.dachsmate.views.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = UserController.MAIN)
public class UserController {

    @Autowired
    UserService userService;

    public static final String MAIN = "api/main";
    public static final String MAIN_USER = "/user";
  //  public static final String MAIN_ADMIN = "/admin";
  //  public static final String MAIN_CARD = "/card";

    // Request mapping names

    public static final String USER_LOGIN = "/login";
    public static final String USER_NEW = "/newUser";
    public static final String USER_UPDATE = "/updateUser";
    public static final String USER_DELETE = "/deleteUser";
    public static final String USER_LIST = "/users";

    @PostMapping(MAIN_USER + USER_LOGIN)
    public User login(@RequestBody UserView userView) {
        User user = userService.findUserForLoginPassword(userView.getUsername(), userView.getUserPassword());
        return user;
    }

    @RequestMapping(value = "newUser", method = RequestMethod.POST)
    public User createUser(@RequestBody UserView userView) {
        User user = userService.saveUser(userView);
        return user;
    }

    @PostMapping(MAIN_USER + USER_UPDATE)
    public User updateUser(@RequestBody UserView userView) {
        User user = userService.findUserById(userView.getId());
        if (user != null) {
            return userService.updateUser(user, userView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_USER + USER_DELETE)
    public String deleteUser(@RequestBody UserView userView) {
        User user = userService.findUserById(userView.getId());
        if (user != null) {
            return userService.deleteUser(user);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_USER + USER_LIST)
    public List<User> updateUser() {
        return userService.findAllUsers();
    }

}
