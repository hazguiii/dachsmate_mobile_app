package com.dachsmate.controller;

import com.dachsmate.entity.Fuel;
import com.dachsmate.services.FuelService;
import com.dachsmate.views.FuelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dachsmate.controller.UserController.MAIN_USER;
import static com.dachsmate.controller.UserController.USER_LOGIN;

@RestController
@RequestMapping(value = FuelController.MAIN)
public class FuelController {

    @Autowired
    FuelService fuelService;

    public static final String MAIN = "api/main";
    public static final String MAIN_Fuel = "/fuel";
    //  public static final String MAIN_ADMIN = "/admin";
    //  public static final String MAIN_CARD = "/card";

    // Request mapping names

    //public static final String USER_LOGIN = "/login";
    public static final String Fuel_NEW = "/newFuel";
    public static final String Fuel_UPDATE = "/updateFuel";
    public static final String Fuel_DELETE = "/deleteFuel";
    public static final String Fuel_LIST = "/fuels";


//    @PostMapping(MAIN_Fuel + Fuel_LOGIN)
//    public User login(@RequestBody UserView userView) {
//
//        User user = userService.findUserForLoginPassword(userView.getUsername(), userView.getUserPassword());
//        return user;
//    }

    @PostMapping(MAIN_Fuel + Fuel_NEW)
    public Fuel createFuel(@RequestBody FuelView fuelView) {
        Fuel fuel = fuelService.saveFuel(fuelView);
        return fuel;
    }

    @PostMapping(MAIN_Fuel + Fuel_UPDATE)
    public Fuel updateFuel(@RequestBody FuelView fuelView) {
        Fuel fuel = fuelService.findFuelById(fuelView.getId());
        if (fuel != null) {
            return fuelService.updateFuel(fuel, fuelView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_Fuel + Fuel_DELETE)
    public String deleteFuel(@RequestBody FuelView fuelView) {
        Fuel fuel = fuelService.findFuelById(fuelView.getId());
        if (fuel != null) {
            return fuelService.deleteFuel(fuel);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_Fuel + Fuel_LIST)
    public List<Fuel> updateFuel() {
        return fuelService.findAllFuels();
    }

}
