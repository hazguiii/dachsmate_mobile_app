package com.dachsmate.controller;

import com.dachsmate.entity.Vehicle;
import com.dachsmate.services.VehicleService;
import com.dachsmate.views.VehicleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = VehicleController.MAIN)
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    public static final String MAIN = "api/main";
    public static final String MAIN_VEHICLE = "/vehicle";
    //  public static final String MAIN_VEHICLE = "/vehicle";
    //  public static final String MAIN_VEHICLE = "/vehicle";

    // Request mapping names


    public static final String VEHICLE_NEW = "/newVehicle";
    public static final String VEHICLE_UPDATE = "/updateVehicle";
    public static final String VEHICLE_DELETE = "/deleteVehicles";
    public static final String VEHICLE_LIST = "/Vehicles";



    @PostMapping(MAIN_VEHICLE + VEHICLE_NEW)
    public Vehicle createVehicle(@RequestBody VehicleView vehicleView) {
        Vehicle vehicle = vehicleService.saveVehicle(vehicleView);
        return vehicle;
    }

    @PostMapping(MAIN_VEHICLE + VEHICLE_UPDATE)
    public Vehicle updateVehicle(@RequestBody VehicleView vehicleView) {
        Vehicle vehicle = vehicleService.findVehicleById(vehicleView.getId());
        if (vehicle != null) {
            return vehicleService.updateVehicle(vehicle, vehicleView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_VEHICLE + VEHICLE_DELETE)
    public String deleteVehicle(@RequestBody VehicleView vehicleView) {
        Vehicle vehicle = vehicleService.findVehicleById(vehicleView.getId());
        if (vehicle != null) {
            return vehicleService.deleteVehicle(vehicle);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_VEHICLE + VEHICLE_LIST)
    public List<Vehicle> updateVehicle() {
        return vehicleService.findAllVehicles();
    }

}
