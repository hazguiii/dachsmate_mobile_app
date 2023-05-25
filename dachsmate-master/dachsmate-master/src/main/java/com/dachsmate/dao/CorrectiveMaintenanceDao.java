package com.dachsmate.dao;

import com.dachsmate.entity.CorrectiveMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrectiveMaintenanceDao extends JpaRepository<CorrectiveMaintenance,Integer> {

    CorrectiveMaintenance findCorrectiveMaintenanceById(Integer id);
}
