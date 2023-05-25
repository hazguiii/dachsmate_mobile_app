package com.dachsmate.views;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;


public class MileageView {

    private Integer id;
    private String mileage;
    private Date date;
    private Time time;
    private Blob image;
    private Integer userId;
    private Integer vehicleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMileage() {return mileage;}

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Time getTime() {
        return time;
    }

    public void setDate(Time time) {
        this.time = time;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }



}
