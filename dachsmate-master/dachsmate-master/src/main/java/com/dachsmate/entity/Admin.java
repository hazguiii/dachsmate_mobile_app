package com.dachsmate.entity;

import com.dachsmate.views.AdminView;
//import com.dachsmate.views.UserView;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries( {
    @NamedQuery( name = "Admin.findAdminById", query = "from Admin as u where u.id = :id " ),
    @NamedQuery( name = "Admin.findAllUsers", query = "from Admin as u order by id desc " ),
    @NamedQuery( name = "Admin.findForLoginPassword", query = "from Admin as u where u.name = :name and u.password= :password " )
} )
@Entity
public class Admin {
    private Integer id;
    private String name;
    private String email;
    private String password;

    public static Admin newInstance(Admin ad){

        Admin admin =new Admin();
        admin.setId(ad.getId());
        admin.setEmail(ad.getEmail());
        admin.setName(ad.getName());
        admin.setPassword(ad.getPassword());

       return admin;
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
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) && Objects.equals(name, admin.name) && Objects.equals(email, admin.email) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }
}
