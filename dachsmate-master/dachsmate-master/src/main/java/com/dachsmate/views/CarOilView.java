package com.dachsmate.views;

import java.sql.Blob;
import java.sql.Date;

public class CarOilView {

    private Integer id;
    private Date date;
    private Blob image;
    private String prix;

    private Integer userId;
    private Integer vehicleId;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPrix() {
        return prix;
    }

    public void setPrice(String prix) {
        this.prix = prix;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

}
