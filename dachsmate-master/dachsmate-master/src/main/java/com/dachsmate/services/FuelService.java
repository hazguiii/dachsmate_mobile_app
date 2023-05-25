package com.dachsmate.services;

import com.dachsmate.entity.Fuel;
import com.dachsmate.views.FuelView;

import java.util.List;

public interface FuelService {

    //User findUserForLoginPassword(String username, String userPassword);

    Fuel findFuelById(Integer id);

    Fuel saveFuel(FuelView fuelView);

    Fuel updateFuel(Fuel fuel, FuelView fuelView);

    String deleteFuel(Fuel fuel);

    List<Fuel> findAllFuels();
}
