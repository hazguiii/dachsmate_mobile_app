package com.dachsmate.dao;

import com.dachsmate.entity.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelDao extends JpaRepository<Fuel,Integer> {

    //CarOil findForLoginPassword(String username,String userPassword);
    Fuel findFuelById(Integer id);
}
