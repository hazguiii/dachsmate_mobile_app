package com.dachsmate.entity;

import com.dachsmate.views.VehicleView;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries( {
    @NamedQuery( name = "Vehicle.findVehicleById", query = "from Vehicle as u where u.id = :id " ),
    @NamedQuery( name = "Vehicle.findAllVehicles", query = "from Vehicle as u order by id desc " ),

} )
@Entity
public class Vehicle {
    private Integer id;
    private String name;
    private String matricule;
    private String mileage;
    private String fuelConsumption;
    private Integer cardId;

    public static Vehicle newInstance(VehicleView vehicleView){

        Vehicle vehicle =new Vehicle();
        vehicle.setName(vehicleView.getName());
        vehicle.setMatricule(vehicleView.getMatricule());
        vehicle.setMileage(vehicleView.getMileage());
        vehicle.setFuelConsumption(vehicleView.getFuelConsumption());



        return vehicle;
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
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "matricule", nullable = false, length = 255)
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Basic
    @Column(name = "mileage", nullable = false, length = 255)
    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    @Basic
    @Column(name = "fuel_consumption", nullable = false, length = 255)
    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Basic
    @Column(name = "card_id", nullable = false)
    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(name, vehicle.name) && Objects.equals(matricule, vehicle.matricule) && Objects.equals(mileage, vehicle.mileage) && Objects.equals(fuelConsumption, vehicle.fuelConsumption) && Objects.equals(cardId, vehicle.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, matricule, mileage, fuelConsumption, cardId);
    }
}
