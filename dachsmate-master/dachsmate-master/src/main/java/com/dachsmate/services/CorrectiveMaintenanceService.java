package com.dachsmate.services;

import com.dachsmate.entity.CorrectiveMaintenance;
import com.dachsmate.views.CorrectiveMaintenanceView;

import java.util.List;

public interface CorrectiveMaintenanceService {


    CorrectiveMaintenance findCorrectiveMaintenanceById(Integer id);

    CorrectiveMaintenance saveCorrectiveMaintenance(CorrectiveMaintenanceView correctiveMaintenanceView);

    CorrectiveMaintenance updateCorrectiveMaintenance(CorrectiveMaintenance correctiveMaintenance, CorrectiveMaintenanceView correctiveMaintenanceView);

    String deleteCorrectiveMaintenance(CorrectiveMaintenance correctiveMaintenance);

    List<CorrectiveMaintenance> findAllCorrectiveMaintenances();
}
