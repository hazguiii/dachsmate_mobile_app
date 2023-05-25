package com.dachsmate.services;

import com.dachsmate.entity.Accidentology;
import com.dachsmate.views.AccidentologyView;

import java.util.List;

public interface AccidentologyService {

//    User findUserForLoginPassword(String username, String userPassword);

    Accidentology findAccidentologyById(Integer id);

    Accidentology saveAccidentology(AccidentologyView accidentologyView);

    Accidentology updateAccidentology(Accidentology accidentology, AccidentologyView accidentologyView);

    String deleteAccidentology(Accidentology accidentology);

    List<Accidentology> findAllAccidentologies();
}


