package com.dachsmate.entity;

import com.dachsmate.views.UserView;

import javax.persistence.*;
import java.util.Objects;


@NamedQueries( {
        @NamedQuery( name = "User.findUserById", query = "from User as u where u.id = :id " ),
        @NamedQuery( name = "User.findAllUsers", query = "from User as u order by id desc " ),
        @NamedQuery( name = "User.findForLoginPassword", query = "from User as u where u.username = :username and u.userPassword= :userPassword " )
} )
@Entity
public class User {
    private Integer id;
    private String username;
    private String useremail;
    private String userPassword;
    private Integer vehicleId;

    public static User newInstance(UserView userView){

        User user =new User();
        user.setUseremail(userView.getUseremail());
        user.setUsername(userView.getUsername());
        user.setUserPassword(userView.getUserPassword());
        user.setVehicleId(userView.getVehicleId());
        return user;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "useremail", nullable = false, length = 255)
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Basic
    @Column(name = "userpassword", nullable = false, length = 255)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(useremail, user.useremail) && Objects.equals(userPassword, user.userPassword) && Objects.equals(vehicleId, user.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, useremail, userPassword, vehicleId);
    }
}
