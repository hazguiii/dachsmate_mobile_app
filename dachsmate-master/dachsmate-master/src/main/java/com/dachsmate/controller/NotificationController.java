package com.dachsmate.controller;

import com.dachsmate.entity.Notification;
import com.dachsmate.services.NotificationService;
import com.dachsmate.views.NotificationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = NotificationController.MAIN)
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    public static final String MAIN = "api/main";
    public static final String MAIN_NOTIFICATION = "/notification";
    // Request mapping names

    public static final String NOTIFICATION_LOGIN = "/login";
    public static final String NOTIFICATION_NEW = "/newNotification";
    public static final String NOTIFICATION_UPDATE = "/updateNotification";
    public static final String NOTIFICATION_DELETE = "/deleteNotifications";
    public static final String NOTIFICATION_LIST = "/Notifications";



    @PostMapping(MAIN_NOTIFICATION + NOTIFICATION_NEW)
    public Notification createNotification(@RequestBody NotificationView notificationView) {
        Notification notification = notificationService.saveNotification(notificationView);
        return notification;
    }

    @PostMapping(MAIN_NOTIFICATION + NOTIFICATION_UPDATE)
    public Notification updateNotification(@RequestBody NotificationView notificationView) {
        Notification notification = notificationService.findNotificationById(notificationView.getId());
        if (notification != null) {
            return notificationService.updateNotification(notification, notificationView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_NOTIFICATION + NOTIFICATION_DELETE)
    public String deleteNotification(@RequestBody NotificationView notificationView) {
        Notification notification = notificationService.findNotificationById(notificationView.getId());
        if (notification != null) {
            return notificationService.deleteNotification(notification);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_NOTIFICATION + NOTIFICATION_LIST)
    public List<Notification> updateNotification() {
        return notificationService.findAllNotifications();
    }

}
