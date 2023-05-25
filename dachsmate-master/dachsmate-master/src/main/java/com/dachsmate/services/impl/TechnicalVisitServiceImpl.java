package com.dachsmate.services.impl;

import com.dachsmate.dao.TechnicalVisitDao;
import com.dachsmate.entity.TechnicalVisit;
import com.dachsmate.services.TechnicalVisitService;
import com.dachsmate.views.TechnicalVisitView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalVisitServiceImpl implements TechnicalVisitService {

    @Autowired
    TechnicalVisitDao technicalVisitDao;



    @Override
    public TechnicalVisit findTechnicalVisitById(Integer id) {
        return technicalVisitDao.findTechnicalVisitById(id);
    }

    @Override
    public TechnicalVisit saveTechnicalVisit(TechnicalVisitView technicalVisitView) {
        return technicalVisitDao.save(TechnicalVisit.newInstance(technicalVisitView));
    }

    @Override
    public TechnicalVisit updateTechnicalVisit(TechnicalVisit technicalVisit, TechnicalVisitView technicalVisitView) {

        technicalVisit.setAmount(technicalVisitView.getAmount());
        technicalVisit.setVisitDate(technicalVisitView.getVisitDate());
        technicalVisit.setImage(technicalVisitView.getImage());

        technicalVisitDao.saveAndFlush(technicalVisit);
        return technicalVisit;
    }

    @Override
    public List<TechnicalVisit> findAllTechnicalVisits() {
        return technicalVisitDao.findAll();
    }

    @Override
    public String deleteTechnicalVisit(TechnicalVisit technicalVisit) {
        technicalVisitDao.delete(technicalVisit);
        return "ok";
    }
}
