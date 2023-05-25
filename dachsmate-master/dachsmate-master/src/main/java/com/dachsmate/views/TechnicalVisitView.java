package com.dachsmate.views;

import java.sql.Blob;
import java.sql.Date;



public class TechnicalVisitView {

    private Integer id;
    private Integer amount;
    private Date visitdate;
    private Blob image;
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

    public Date getVisitDate() {
        return visitdate;
    }

    public void setDate(Date visitdate) {
        this.visitdate = visitdate;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }



}
