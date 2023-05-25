package com.dachsmate.dao;

import com.dachsmate.entity.CarOil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOilDao extends JpaRepository<CarOil,Integer> {

    //CarOil findForLoginPassword(String username,String userPassword);
    CarOil findCarOilById(Integer id);
}
