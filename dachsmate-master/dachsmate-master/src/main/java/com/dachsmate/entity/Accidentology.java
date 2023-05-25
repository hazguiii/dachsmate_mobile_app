package com.dachsmate.entity;

import com.dachsmate.views.AccidentologyView;
import com.dachsmate.views.UserView;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;

@NamedQueries( {
    @NamedQuery( name = "User.findAccidentologyById", query = "from Accidentology as u where u.id = :id " ),
    @NamedQuery( name = "User.findAllAccidentologies", query = "from Accidentology as u order by id desc " ),

} )
@Entity
@Table(name = "accidentology", schema = "dachsmate", catalog = "")
public class Accidentology {
    private Integer id;
    private Date date;
    private Blob image;
    private String description;
    private Boolean faulty;
    private Integer userId;
    private Integer vehicleId;

    public static Accidentology newInstance(AccidentologyView AccidentologyView){

        Accidentology accidentology =new Accidentology();
        accidentology.setDate(AccidentologyView.getDate());
        accidentology.setImage(AccidentologyView.getImage());
        accidentology.setFaulty(AccidentologyView.getFaulty());
        accidentology.setDescription(AccidentologyView.getDescription());
       // accidentology.setVehicleId(AccidentologyView.getVehicleId());
      //  accidentology.setUserId(AccidentologyView.getUserId());
        return accidentology;
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
    @Column(name = "image", nullable = false)
    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
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
    @Column (name = "faulty", nullable = false)
    public Boolean GetFaulty() {
        return faulty;

    }
    public void setFaulty(Boolean faulty) {
        this.faulty = faulty;
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
        Accidentology that = (Accidentology) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(image, that.image) && Objects.equals(description, that.description) && Objects.equals(faulty, that.faulty) && Objects.equals(userId, that.userId) && Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, image, description, faulty, userId, vehicleId);
    }


}
