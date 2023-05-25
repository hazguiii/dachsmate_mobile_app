package com.dachsmate.entity;

import com.dachsmate.views.MileageView;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@NamedQueries( {
    @NamedQuery( name = "Mileage.findMileageById", query = "from Mileage as u where u.id = :id " ),
    @NamedQuery( name = "Mileage.findAllMileages", query = "from Mileage as u order by id desc " ),
} )
@Entity
@Table(name = "mileage", schema = "dachsmate", catalog = "")

public class Mileage {
    private Integer id;
    private String mileage;
    private Date date;
    private Time time;
    private Blob image;
    private Integer userId;
    private Integer vehicleId;

    public static Mileage newInstance(MileageView mileageView){

        Mileage mileage =new Mileage();
        mileage.setMileage(mileageView.getMileage());
        mileage.setDate(mileageView.getDate());
        mileage.setTime(mileageView.getTime());
        mileage.setImage(mileageView.getImage());


        return mileage;
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
    @Column(name = "mileage", nullable = false)
    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
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
    @Column(name = "time", nullable = false)
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Basic
    @Column(name = "image", nullable = false)
    public Blob getImage() {
        return image;
    }

    public void setImage(Blob mileage) {
        this.image = image;
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
    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mileage that = (Mileage) o;
        return Objects.equals(id, that.id) && Objects.equals(mileage, that.mileage) && Objects.equals(date, that.date)&& Objects.equals(time, that.time) && Objects.equals(image, that.image) && Objects.equals(userId, that.userId) && Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mileage, date,time,image, userId, vehicleId);
    }
}
