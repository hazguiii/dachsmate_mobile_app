package com.dachsmate.services.impl;

import com.dachsmate.dao.NotificationDao;
import com.dachsmate.entity.Notification;
import com.dachsmate.services.NotificationService;
import com.dachsmate.views.NotificationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationDao notificationDao;



    @Override
    public Notification findNotificationById(Integer id) {
        return notificationDao.findNotificationById(id);
    }

    @Override
    public Notification saveNotification(NotificationView notificationView) {
        return notificationDao.save(Notification.newInstance(notificationView));
    }

    @Override
    public Notification updateNotification(Notification notification, NotificationView notificationView) {


        notification.setMessage(notificationView.getMessage());
        notification.setDate(notificationView.getDate());


        notificationDao.saveAndFlush(notification);
        return notification;
    }

    @Override
    public List<Notification> findAllNotifications() {
        return notificationDao.findAll();
    }

    @Override
    public String deleteNotification(Notification notification) {
        notificationDao.delete(notification);
        return "ok";
    }
}
