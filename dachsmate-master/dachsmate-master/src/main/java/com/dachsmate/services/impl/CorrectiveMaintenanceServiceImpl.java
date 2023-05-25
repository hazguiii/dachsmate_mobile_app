package com.dachsmate.services.impl;

import com.dachsmate.dao.CorrectiveMaintenanceDao;
import com.dachsmate.entity.CorrectiveMaintenance;
import com.dachsmate.services.CorrectiveMaintenanceService;
import com.dachsmate.views.CorrectiveMaintenanceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrectiveMaintenanceServiceImpl implements CorrectiveMaintenanceService {

    @Autowired
    CorrectiveMaintenanceDao correctiveMaintenanceDao;



    @Override
    public CorrectiveMaintenance findCorrectiveMaintenanceById(Integer id) {
        return correctiveMaintenanceDao.findCorrectiveMaintenanceById(id);
    }

    @Override
    public CorrectiveMaintenance saveCorrectiveMaintenance(CorrectiveMaintenanceView correctiveMaintenanceView) {
        return correctiveMaintenanceDao.save(CorrectiveMaintenance.newInstance(correctiveMaintenanceView));
    }

    @Override
    public CorrectiveMaintenance updateCorrectiveMaintenance(CorrectiveMaintenance correctiveMaintenance, CorrectiveMaintenanceView correctiveMaintenanceView) {

        correctiveMaintenance.setAmount(correctiveMaintenanceView.getAmount());
        correctiveMaintenance.setDate(correctiveMaintenanceView.getDate());
        correctiveMaintenance.setImage(correctiveMaintenanceView.getImage());
        correctiveMaintenance.setMileage(correctiveMaintenanceView.getMileage());
        correctiveMaintenance.setDescription(correctiveMaintenanceView.getDescription());

        correctiveMaintenanceDao.saveAndFlush(correctiveMaintenance);
        return correctiveMaintenance;
    }

    @Override
    public List<CorrectiveMaintenance> findAllCorrectiveMaintenances() {
        return correctiveMaintenanceDao.findAll();
    }

    @Override
    public String deleteCorrectiveMaintenance(CorrectiveMaintenance correctiveMaintenance) {
        correctiveMaintenanceDao.delete(correctiveMaintenance);
        return "ok";
    }
}
