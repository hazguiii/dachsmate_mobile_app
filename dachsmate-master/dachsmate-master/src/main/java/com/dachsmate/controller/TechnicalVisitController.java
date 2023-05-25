package com.dachsmate.controller;

import com.dachsmate.entity.TechnicalVisit;
import com.dachsmate.services.TechnicalVisitService;
import com.dachsmate.views.TechnicalVisitView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = TechnicalVisitController.MAIN)
public class TechnicalVisitController {

    @Autowired
    TechnicalVisitService technicalVisitService;

    public static final String MAIN = "api/main";
    public static final String MAIN_TECHNICALVISIT = "/technicalVisit";
    // Request mapping names

    public static final String TECHNICALVISIT_LOGIN = "/login";
    public static final String TECHNICALVISIT_NEW = "/newTechnicalVisit";
    public static final String TECHNICALVISIT_UPDATE = "/updateTechnicalVisit";
    public static final String TECHNICALVISIT_DELETE = "/deleteTechnicalVisits";
    public static final String TECHNICALVISIT_LIST = "/TechnicalVisits";



    @PostMapping(MAIN_TECHNICALVISIT + TECHNICALVISIT_NEW)
    public TechnicalVisit createTechnicalVisit(@RequestBody TechnicalVisitView technicalVisitView) {
        TechnicalVisit technicalVisit = technicalVisitService.saveTechnicalVisit(technicalVisitView);
        return technicalVisit;
    }

    @PostMapping(MAIN_TECHNICALVISIT + TECHNICALVISIT_UPDATE)
    public TechnicalVisit updateTechnicalVisit(@RequestBody TechnicalVisitView technicalVisitView) {
        TechnicalVisit technicalVisit = technicalVisitService.findTechnicalVisitById(technicalVisitView.getId());
        if (technicalVisit != null) {
            return technicalVisitService.updateTechnicalVisit(technicalVisit, technicalVisitView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_TECHNICALVISIT + TECHNICALVISIT_DELETE)
    public String deleteTechnicalVisit(@RequestBody TechnicalVisitView technicalVisitView) {
        TechnicalVisit technicalVisit = technicalVisitService.findTechnicalVisitById(technicalVisitView.getId());
        if (technicalVisit != null) {
            return technicalVisitService.deleteTechnicalVisit(technicalVisit);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_TECHNICALVISIT + TECHNICALVISIT_LIST)
    public List<TechnicalVisit> updateTechnicalVisit() {
        return technicalVisitService.findAllTechnicalVisits();
    }

}
