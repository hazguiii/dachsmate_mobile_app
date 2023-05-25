package com.dachsmate.dao;

import com.dachsmate.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle,Integer> {

    Vehicle findVehicleById(Integer id);
}
