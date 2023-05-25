package com.dachsmate.services.impl;

import com.dachsmate.dao.AccidentologyDao;
import com.dachsmate.entity.Accidentology;
import com.dachsmate.services.AccidentologyService;
import com.dachsmate.views.AccidentologyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentologyServiceImpl implements AccidentologyService {

    @Autowired
    AccidentologyDao accidentologyDao;



    @Override
    public Accidentology findAccidentologyById(Integer id) {
        return accidentologyDao.findAccidentologyById(id);
    }

    @Override
    public Accidentology saveAccidentology(AccidentologyView accidentologyView) {
        return accidentologyDao.save(Accidentology.newInstance(accidentologyView));
    }

    @Override
    public Accidentology updateAccidentology(Accidentology accidentology, AccidentologyView accidentologyView) {


        accidentology.setDate(accidentologyView.getDate());
        accidentology.setImage(accidentologyView.getImage());
        accidentology.setFaulty(accidentologyView.getFaulty());


        accidentologyDao.saveAndFlush(accidentology);
        return accidentology;
    }

    @Override
    public List<Accidentology> findAllAccidentologies() {
        return accidentologyDao.findAll();}

    @Override
    public String deleteAccidentology(Accidentology accidentology) {
        accidentologyDao.delete(accidentology);
        return "ok";
    }
}
