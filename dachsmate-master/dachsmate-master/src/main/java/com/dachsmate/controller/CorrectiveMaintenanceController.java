package com.dachsmate.controller;

import com.dachsmate.entity.CorrectiveMaintenance;
import com.dachsmate.services.CorrectiveMaintenanceService;
import com.dachsmate.views.CorrectiveMaintenanceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = CorrectiveMaintenanceController.MAIN)
public class CorrectiveMaintenanceController {

    @Autowired
    CorrectiveMaintenanceService correctiveMaintenanceService;

    public static final String MAIN = "api/main";
    public static final String MAIN_CORRECTIVEMAINTENANCE = "/correctiveMaintenance";
    // Request mapping names

    public static final String CORRECTIVEMAINTENANCE_LOGIN = "/login";
    public static final String CORRECTIVEMAINTENANCE_NEW = "/newCorrectiveMaintenance";
    public static final String CORRECTIVEMAINTENANCE_UPDATE = "/updateCorrectiveMaintenance";
    public static final String CORRECTIVEMAINTENANCE_DELETE = "/deleteCorrectiveMaintenances";
    public static final String CORRECTIVEMAINTENANCE_LIST = "/CorrectiveMaintenances";



    @PostMapping(MAIN_CORRECTIVEMAINTENANCE + CORRECTIVEMAINTENANCE_NEW)
    public CorrectiveMaintenance createCorrectiveMaintenance(@RequestBody CorrectiveMaintenanceView correctiveMaintenanceView) {
        CorrectiveMaintenance correctiveMaintenance = correctiveMaintenanceService.saveCorrectiveMaintenance(correctiveMaintenanceView);
        return correctiveMaintenance;
    }

    @PostMapping(MAIN_CORRECTIVEMAINTENANCE + CORRECTIVEMAINTENANCE_UPDATE)
    public CorrectiveMaintenance updateCorrectiveMaintenance(@RequestBody CorrectiveMaintenanceView correctiveMaintenanceView) {
        CorrectiveMaintenance correctiveMaintenance = correctiveMaintenanceService.findCorrectiveMaintenanceById(correctiveMaintenanceView.getId());
        if (correctiveMaintenance != null) {
            return correctiveMaintenanceService.updateCorrectiveMaintenance(correctiveMaintenance, correctiveMaintenanceView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_CORRECTIVEMAINTENANCE + CORRECTIVEMAINTENANCE_DELETE)
    public String deleteCorrectiveMaintenance(@RequestBody CorrectiveMaintenanceView correctiveMaintenanceView) {
        CorrectiveMaintenance correctiveMaintenance = correctiveMaintenanceService.findCorrectiveMaintenanceById(correctiveMaintenanceView.getId());
        if (correctiveMaintenance != null) {
            return correctiveMaintenanceService.deleteCorrectiveMaintenance(correctiveMaintenance);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_CORRECTIVEMAINTENANCE + CORRECTIVEMAINTENANCE_LIST)
    public List<CorrectiveMaintenance> updateCorrectiveMaintenance() {
        return correctiveMaintenanceService.findAllCorrectiveMaintenances();
    }

}
