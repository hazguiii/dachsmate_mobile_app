package com.dachsmate.services;

import com.dachsmate.entity.Notification;
import com.dachsmate.views.NotificationView;

import java.util.List;

public interface NotificationService {

    //User findUserForLoginPassword(String username, String userPassword);

    Notification findNotificationById(Integer id);

    Notification saveNotification(NotificationView notificationView);

    Notification updateNotification(Notification notification, NotificationView notificationView);

    String deleteNotification(Notification notification);

    List<Notification> findAllNotifications();
}
