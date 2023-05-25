//mileageDao
package com.dachsmate.dao;

import com.dachsmate.entity.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MileageDao extends JpaRepository<Mileage,Integer> {

    Mileage findMileageById(Integer id);
}
