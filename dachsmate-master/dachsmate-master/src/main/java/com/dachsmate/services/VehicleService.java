package com.dachsmate.services;

import com.dachsmate.entity.Vehicle;
import com.dachsmate.views.VehicleView;

import java.util.List;

public interface VehicleService {


    Vehicle findVehicleById(Integer id);

    Vehicle saveVehicle(VehicleView vehicleView);

    Vehicle updateVehicle(Vehicle vehicle, VehicleView vehicleView);

    String deleteVehicle(Vehicle vehicle);

    List<Vehicle> findAllVehicles();
}
