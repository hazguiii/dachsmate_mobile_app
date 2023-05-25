package com.dachsmate.dao;

import com.dachsmate.entity.Accidentology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentologyDao extends JpaRepository<Accidentology,Integer> {

//    Accidentology findForLoginPassword(String username,String userPassword);
Accidentology findAccidentologyById(Integer id);
}
