package com.dachsmate.controller;

import com.dachsmate.entity.CarOil;
import com.dachsmate.services.CarOilService;
import com.dachsmate.views.CarOilView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = CarOilController.MAIN)
public class CarOilController {

    @Autowired
    CarOilService carOilService;

    public static final String MAIN = "api/main";
    public static final String MAIN_CarOil = "/carOil";
    //  public static final String MAIN_ADMIN = "/admin";
    //  public static final String MAIN_CARD = "/card";

    // Request mapping names

//    public static final String USER_LOGIN = "/login";
    public static final String CarOil_NEW = "/newCarOil";
    public static final String CarOil_UPDATE = "/updateCarOil";
    public static final String CarOil_DELETE = "/deleteCarOil";
    public static final String CarOil_LIST = "/CarOils";

//    @PostMapping(MAIN_USER + USER_LOGIN)
//    public User login(@RequestBody UserView userView) {
//
//        User user = userService.findUserForLoginPassword(userView.getUsername(), userView.getUserPassword());
//        return user;
//    }

    @PostMapping(MAIN_CarOil + CarOil_NEW)
    public CarOil createCarOil(@RequestBody CarOilView carOilView) {
        CarOil carOil = carOilService.saveCarOil(carOilView);
        return carOil;
    }

    @PostMapping(MAIN_CarOil + CarOil_UPDATE)
    public CarOil updateCarOil(@RequestBody CarOilView carOilView) {
        CarOil carOil = carOilService.findCarOilById(carOilView.getId());
        if (carOil != null) {
            return carOilService.updateCarOil(carOil, carOilView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_CarOil + CarOil_DELETE)
    public String deleteCarOil(@RequestBody CarOilView carOilView) {
        CarOil carOil = carOilService.findCarOilById(carOilView.getId());
        if (carOil != null) {
            return carOilService.deleteCarOil(carOil);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_CarOil + CarOil_LIST)
    public List< CarOil> updateUser() {
        return  carOilService.findAllCarOils();
    }

}
