package com.dachsmate.services;

import com.dachsmate.entity.CarOil;
import com.dachsmate.views.CarOilView;

import java.util.List;

public interface CarOilService {

    //User findUserForLoginPassword(String username, String userPassword);

    CarOil findCarOilById(Integer id);

    CarOil saveCarOil(CarOilView carOilView);

    CarOil updateCarOil(CarOil carOil, CarOilView carOilView);

    String deleteCarOil(CarOil carOil);

    List<CarOil> findAllCarOils();
}
