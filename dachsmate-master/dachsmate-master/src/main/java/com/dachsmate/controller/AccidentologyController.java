package com.dachsmate.controller;

import com.dachsmate.entity.Accidentology;
import com.dachsmate.services.AccidentologyService;
import com.dachsmate.views.AccidentologyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = AccidentologyController.MAIN)
public class AccidentologyController {

    @Autowired
    AccidentologyService accidentologyService;

    public static final String MAIN = "api/main";
    public static final String MAIN_ACCIDENTOLOGY = "/accidentology";
    // Request mapping names

    public static final String ACCIDENTOLOGY_LOGIN = "/login";
    public static final String ACCIDENTOLOGY_NEW = "/newAccidentology";
    public static final String ACCIDENTOLOGY_UPDATE = "/updateAccidentology";
    public static final String ACCIDENTOLOGY_DELETE = "/deleteAccidentologies";
    public static final String ACCIDENTOLOGY_LIST = "/Accidentologies";



    @PostMapping(MAIN_ACCIDENTOLOGY + ACCIDENTOLOGY_NEW)
    public Accidentology createAccidentology(@RequestBody AccidentologyView accidentologyView) {
        Accidentology accidentology = accidentologyService.saveAccidentology(accidentologyView);
        return accidentology;
    }

    @PostMapping(MAIN_ACCIDENTOLOGY + ACCIDENTOLOGY_UPDATE)
    public Accidentology updateAccidentology(@RequestBody AccidentologyView accidentologyView) {
        Accidentology accidentology = accidentologyService.findAccidentologyById(accidentologyView.getId());
        if (accidentology != null) {
            return accidentologyService.updateAccidentology(accidentology, accidentologyView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_ACCIDENTOLOGY + ACCIDENTOLOGY_DELETE)
    public String deleteAccidentology(@RequestBody AccidentologyView accidentologyView) {
        Accidentology accidentology = accidentologyService.findAccidentologyById(accidentologyView.getId());
        if (accidentology != null) {
            return accidentologyService.deleteAccidentology(accidentology);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_ACCIDENTOLOGY + ACCIDENTOLOGY_LIST)
    public List<Accidentology> updateAccidentology() {
        return accidentologyService.findAllAccidentologies();
    }

}
