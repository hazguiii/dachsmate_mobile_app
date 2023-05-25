package com.dachsmate.dao;

import com.dachsmate.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDao extends JpaRepository<Card,Integer> {

   // Card findForLoginPassword(String adminname,String adminPassword);
    Card findCardById(Integer id);
}
