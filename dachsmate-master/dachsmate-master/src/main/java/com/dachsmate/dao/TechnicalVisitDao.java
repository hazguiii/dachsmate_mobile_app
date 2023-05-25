//TechnicalVisitDao
package com.dachsmate.dao;

import com.dachsmate.entity.TechnicalVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalVisitDao extends JpaRepository<TechnicalVisit,Integer> {

    TechnicalVisit findTechnicalVisitById(Integer id);
}
