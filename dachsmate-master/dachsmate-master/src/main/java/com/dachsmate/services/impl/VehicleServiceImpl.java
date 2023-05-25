package com.dachsmate.services.impl;

import com.dachsmate.dao.VehicleDao;
import com.dachsmate.entity.Vehicle;
import com.dachsmate.services.VehicleService;
import com.dachsmate.views.VehicleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDao vehicleDao;



    @Override
    public Vehicle findVehicleById(Integer id) {
        return vehicleDao.findVehicleById(id);
    }

    @Override
    public Vehicle saveVehicle(VehicleView vehicleView) {return vehicleDao.save(Vehicle.newInstance(vehicleView));
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, VehicleView vehicleView) {

        vehicle.setName(vehicleView.getName());
        vehicle.setMatricule(vehicleView.getMatricule());
        vehicle.setMileage(vehicleView.getMileage());
        vehicle.setFuelConsumption(vehicleView.getFuelConsumption());


        vehicleDao.saveAndFlush(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        return vehicleDao.findAll();
    }

    @Override
    public String deleteVehicle(Vehicle vehicle) {
        vehicleDao.delete(vehicle);
        return "ok";
    }
}
