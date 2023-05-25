package com.dachsmate.entity;
import com.dachsmate.views.CarOilView;
import com.dachsmate.views.CardView;
import com.dachsmate.views.UserView;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;
@NamedQueries( {
    @NamedQuery( name = "CarOil.findCarOilById", query = "from CarOil as u where u.id = :id " ),
    @NamedQuery( name = "CarOil.findAllCarOils", query = "from CarOil as u order by id desc " ),
} )
@Entity
@Table(name = "Car_oil", schema = "dachsmate", catalog = "")
public class CarOil {
    private Integer id;
    private Date date;
    private String prix;
    private Blob image;
    private Integer userId;
    private Integer vehicleId;

    public static CarOil newInstance(CarOilView carOilView){

        CarOil carOil =new CarOil();
        carOil.setDate(carOilView.getDate());
        carOil.setPrix(carOilView.getPrix());
        carOil.setImage(carOilView.getImage());


        return carOil;
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
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Basic
    @Column(name = "prix", nullable = false)
    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }


    @Basic
    @Column(name = "image", nullable = false)
    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
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


    public void setVehicleId(Integer vehicleId) {this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOil that = (CarOil) o;
        return Objects.equals(id, that.id) &&  Objects.equals(date, that.date) &&Objects.equals(prix, that.prix) &&Objects.equals(image, that.image) && Objects.equals(userId, that.userId) && Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date,prix,image ,userId, vehicleId);
    }}




