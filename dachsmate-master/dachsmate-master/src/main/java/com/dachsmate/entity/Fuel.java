package com.dachsmate.entity;

import com.dachsmate.views.FuelView;
import com.dachsmate.views.UserView;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;

@NamedQueries( {
    @NamedQuery( name = "Fuel.findFuelById", query = "from Fuel as u where u.id = :id " ),
    @NamedQuery( name = "Fuel.findAllFuels", query = "from Fuel as u order by id desc " ),
} )
@Entity
@Table(name = "fuel", schema = "dachsmate", catalog = "")
public class Fuel {
    private Integer id;
    private String prix;

    private Blob image;
    private Date date;
    private Integer userId;
    private Integer vehicleId;

    public static Fuel newInstance(FuelView fuelView){

        Fuel fuel =new Fuel();
        fuel.setPrix(fuelView.getPrix());
        fuel.setImage(fuelView.getImage());
        fuel.setDate(fuelView.getDate());
        fuel.setUserId(fuelView.getUserId());
        fuel.setVehicleId(fuelView.getVehicleId());
        return fuel;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        Fuel that = (Fuel) o;
        return Objects.equals(id, that.id) && Objects.equals(prix, that.prix) && Objects.equals(date, that.date) && Objects.equals(userId, that.userId) && Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prix, date, userId, vehicleId);
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

}


