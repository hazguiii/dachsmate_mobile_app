package com.dachsmate.services;

import com.dachsmate.entity.TechnicalVisit;
import com.dachsmate.views.TechnicalVisitView;

import java.util.List;

public interface TechnicalVisitService {


    TechnicalVisit findTechnicalVisitById(Integer id);

    TechnicalVisit saveTechnicalVisit(TechnicalVisitView technicalVisitView);

    TechnicalVisit updateTechnicalVisit(TechnicalVisit technicalVisit, TechnicalVisitView technicalVisitView);

    String deleteTechnicalVisit(TechnicalVisit technicalVisit);

    List<TechnicalVisit> findAllTechnicalVisits();
}
