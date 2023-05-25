package com.dachsmate.controller;

import com.dachsmate.entity.Mileage;
import com.dachsmate.services.MileageService;
import com.dachsmate.views.MileageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = MileageController.MAIN)
public class MileageController {

    @Autowired
    MileageService mileageService;

    public static final String MAIN = "api/main";
    public static final String MAIN_MILEAGE = "/mileage";
    // Request mapping names

    public static final String MILEAGE_LOGIN = "/login";
    public static final String MILEAGE_NEW = "/newMileage";
    public static final String MILEAGE_UPDATE = "/updateMileage";
    public static final String MILEAGE_DELETE = "/deleteMileages";
    public static final String MILEAGE_LIST = "/Mileages";



    @PostMapping(MAIN_MILEAGE + MILEAGE_NEW)
    public Mileage createMileage(@RequestBody MileageView mileageView) {
        Mileage mileage = mileageService.saveMileage(mileageView);
        return mileage;
    }

    @PostMapping(MAIN_MILEAGE + MILEAGE_UPDATE)
    public Mileage updateMileage(@RequestBody MileageView mileageView) {
        Mileage mileage = mileageService.findMileageById(mileageView.getId());
        if (mileage != null) {
            return mileageService.updateMileage(mileage, mileageView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_MILEAGE + MILEAGE_DELETE)
    public String deleteMileage(@RequestBody MileageView mileageView) {
        Mileage mileage = mileageService.findMileageById(mileageView.getId());
        if (mileage != null) {
            return mileageService.deleteMileage(mileage);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_MILEAGE + MILEAGE_LIST)
    public List<Mileage> updateMileage() {
        return mileageService.findAllMileages();
    }

}
