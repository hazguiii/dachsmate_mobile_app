package com.dachsmate.services.impl;

import com.dachsmate.dao.FuelDao;
import com.dachsmate.entity.Fuel;
import com.dachsmate.services.FuelService;
import com.dachsmate.views.FuelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class FuelServiceImpl implements FuelService {

    @Autowired
    FuelDao fuelDao;

//    @Override
//    public CarOil findUserForLoginPassword(String username, String userPassword) {
//
//        return userDao.findForLoginPassword(username, userPassword);
//    }

    @Override
    public Fuel findFuelById(Integer id) {
        return fuelDao.findFuelById(id);
    }

    @Override
    public Fuel saveFuel(FuelView fuelView) {
        return fuelDao.save(Fuel.newInstance(fuelView));
    }

    @Override
    public Fuel updateFuel(Fuel fuel, FuelView fuelView) {

        fuel.setDate(fuelView.getDate());
        fuel.setImage(fuelView.getImage());
        fuel.setPrix(fuelView.getPrix());

        fuel.setUserId(fuelView.getUserId());
        fuel.setVehicleId(fuelView.getVehicleId());



        fuelDao.saveAndFlush(fuel);
        return fuel;
    }

    @Override
    public List<Fuel> findAllFuels() {
        return fuelDao.findAll();
    }

    @Override
    public String deleteFuel(Fuel fuel) {
        fuelDao.delete(fuel);
        return "ok";
    }
}
