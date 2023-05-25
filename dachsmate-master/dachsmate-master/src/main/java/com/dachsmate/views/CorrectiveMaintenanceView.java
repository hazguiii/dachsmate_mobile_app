package com.dachsmate.views;

import java.sql.Blob;
import java.sql.Date;

public class CorrectiveMaintenanceView {

    private Integer id;
    private Integer amount;
    private Date date;
    private Blob image;
    private String mileage;
    private String description;
    private Integer userId;
    private Integer vehicleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getDescription(){ return description;}

    public void setDescription(String description) {
        this.description = description;
    }


}
