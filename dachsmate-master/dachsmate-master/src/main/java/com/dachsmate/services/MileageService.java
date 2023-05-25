package com.dachsmate.services;

import com.dachsmate.entity.Mileage;
import com.dachsmate.views.MileageView;

import java.util.List;

public interface MileageService {


    Mileage findMileageById(Integer id);

    Mileage saveMileage(MileageView mileageView);

    Mileage updateMileage(Mileage mileage, MileageView mileageView);

    String deleteMileage(Mileage mileage);

    List<Mileage> findAllMileages();
}
