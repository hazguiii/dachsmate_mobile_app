package com.dachsmate.entity;

import com.dachsmate.views.CardView;
import com.dachsmate.views.CorrectiveMaintenanceView;

import javax.persistence.*;
import java.awt.*;
import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;

@NamedQueries( {
    @NamedQuery( name = "CorrectiveMaintenance.findCorrectiveMaintenanceById", query = "from CorrectiveMaintenance as u where u.id = :id " ),
    @NamedQuery( name = "CarOil.findAllCorrectiveMaintenances", query = "from CorrectiveMaintenance as u order by id desc " ),
} )
@Entity
@Table(name = "corrective_maintenance", schema = "dachsmate", catalog = "")
public class CorrectiveMaintenance {
    private Integer id;
    private Integer amount;
    private Date date;
    private Blob image;
    private String mileage;
    private String description;
    private Integer userId;
    private Integer vehicleId;

    public static CorrectiveMaintenance newInstance(CorrectiveMaintenanceView correctiveMaintenanceView){

        CorrectiveMaintenance correctiveMaintenance =new CorrectiveMaintenance();
        correctiveMaintenance.setAmount(correctiveMaintenanceView.getAmount());
        correctiveMaintenance.setDate(correctiveMaintenanceView.getDate());
        correctiveMaintenance.setImage(correctiveMaintenanceView.getImage());
        correctiveMaintenance.setMileage(correctiveMaintenanceView.getMileage());
        correctiveMaintenance.setDescription(correctiveMaintenanceView.getDescription());


        return correctiveMaintenance;
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
    @Column(name = "amount", nullable = false)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
    @Column(name = "image", nullable = false)
    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
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
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        CorrectiveMaintenance that = (CorrectiveMaintenance) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && Objects.equals(date, that.date) && Objects.equals(image, that.image) && Objects.equals(mileage, that.mileage) && Objects.equals(description, that.description) && Objects.equals(userId, that.userId) && Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date, image, mileage, description, userId, vehicleId);
    }
}
