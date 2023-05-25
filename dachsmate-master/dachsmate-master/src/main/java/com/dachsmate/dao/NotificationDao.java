package com.dachsmate.dao;

import com.dachsmate.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDao extends JpaRepository<Notification,Integer> {

    //CarOil findForLoginPassword(String username,String userPassword);
    Notification findNotificationById(Integer id);
}
