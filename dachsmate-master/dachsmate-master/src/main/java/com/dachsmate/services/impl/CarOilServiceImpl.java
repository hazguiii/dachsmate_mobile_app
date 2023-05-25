package com.dachsmate.services.impl;

import com.dachsmate.dao.CarOilDao;
import com.dachsmate.entity.CarOil;
import com.dachsmate.services.CarOilService;
import com.dachsmate.views.CarOilView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarOilServiceImpl implements CarOilService {

    @Autowired
    CarOilDao carOilDao;

//    @Override
//    public CarOil findUserForLoginPassword(String username, String userPassword) {
//
//        return userDao.findForLoginPassword(username, userPassword);
//    }

    @Override
    public CarOil findCarOilById(Integer id) {
        return carOilDao.findCarOilById(id);
    }

    @Override
    public CarOil saveCarOil(CarOilView carOilView) {
        return carOilDao.save(CarOil.newInstance(carOilView));
    }

    @Override
    public CarOil updateCarOil(CarOil carOil, CarOilView carOilView) {

        carOil.setDate(carOilView.getDate());
        carOil.setImage(carOilView.getImage());
        carOil.setPrix(carOilView.getPrix());

        carOil.setUserId(carOilView.getUserId());
        carOil.setVehicleId(carOilView.getVehicleId());



        carOilDao.saveAndFlush(carOil);
        return carOil;
    }

    @Override
    public List<CarOil> findAllCarOils() {
        return carOilDao.findAll();
    }

    @Override
    public String deleteCarOil(CarOil carOil) {
        carOilDao.delete(carOil);
        return "ok";
    }
}
