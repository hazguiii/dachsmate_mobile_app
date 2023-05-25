package com.dachsmate.entity;

import com.dachsmate.views.MileageView;
import com.dachsmate.views.NotificationView;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@NamedQueries( {
    @NamedQuery( name = "Notification.findNotificationById", query = "from Notification as u where u.id = :id " ),
    @NamedQuery( name = "Notification.findAllNotifications", query = "from Notification as u order by id desc " ),
} )
@Entity
public class Notification {
    private Integer id;
    private String message;
    private Date date;
    private Integer userId;

    private Integer vehicleId;


    public static Notification newInstance(NotificationView notificationView){

        Notification notification =new Notification();
        notification.setMessage(notificationView.getMessage());
        notification.setDate(notificationView.getDate());


        return notification;
    }


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }




    @Basic
    @Column(name = "message", nullable = false, length = 255)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "vehicle_id", nullable = false)
    public Integer getVehiculeId() {
        return vehicleId;
    }

    public void setVehiculeId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) && Objects.equals(message, that.message) && Objects.equals(date, that.date) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, date, userId);
    }
}
