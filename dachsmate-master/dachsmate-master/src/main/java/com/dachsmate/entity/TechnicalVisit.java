package com.dachsmate.entity;

import com.dachsmate.views.TechnicalVisitView;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;

@NamedQueries( {
    @NamedQuery( name = "TechnicalVisit.findTechnicalVisitById", query = "from TechnicalVisit as u where u.id = :id " ),
    @NamedQuery( name = "TechnicalVisit.findAllTechnicalVisits", query = "from TechnicalVisit as u order by id desc " ),
} )
@Entity
@Table(name = "technical_visit", schema = "dachsmate", catalog = "")
public class TechnicalVisit {
    private Integer id;
    private Integer amount;
    private Date visitDate;
    private Blob image;
    private Integer userId;
    private Integer vehicleId;
    public static TechnicalVisit newInstance(TechnicalVisitView technicalVisitView){

        TechnicalVisit technicalVisit =new TechnicalVisit();
        technicalVisit.setAmount(technicalVisitView.getAmount());
        technicalVisit.setVisitDate(technicalVisitView.getVisitDate());
        technicalVisit.setImage(technicalVisitView.getImage());


        return technicalVisit;
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
    @Column(name = "visit_date", nullable = false)
    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
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

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnicalVisit that = (TechnicalVisit) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && Objects.equals(visitDate, that.visitDate) && Objects.equals(image, that.image) && Objects.equals(userId, that.userId) && Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, visitDate, image, userId, vehicleId);
    }
}
