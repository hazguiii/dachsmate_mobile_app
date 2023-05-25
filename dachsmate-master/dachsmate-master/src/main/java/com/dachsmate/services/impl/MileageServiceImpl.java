package com.dachsmate.services.impl;

import com.dachsmate.dao.MileageDao;
import com.dachsmate.entity.Mileage;
import com.dachsmate.services.MileageService;
import com.dachsmate.views.MileageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageServiceImpl implements MileageService {

    @Autowired
    MileageDao mileageDao;



    @Override
    public Mileage findMileageById(Integer id) {
        return mileageDao.findMileageById(id);
    }

    @Override
    public Mileage saveMileage(MileageView mileageView) {
        return mileageDao.save(Mileage.newInstance(mileageView));
    }

    @Override
    public Mileage updateMileage(Mileage mileage, MileageView mileageView) {

        mileage.setMileage(mileageView.getMileage());
        mileage.setDate(mileageView.getDate());
        mileage.setTime(mileageView.getTime());
        mileage.setImage(mileageView.getImage());

        mileageDao.saveAndFlush(mileage);
        return mileage;
    }

    @Override
    public List<Mileage> findAllMileages() {
        return mileageDao.findAll();
    }

    @Override
    public String deleteMileage(Mileage mileage) {
        mileageDao.delete(mileage);
        return "ok";
    }
}
