package com.dachsmate.dao;

import com.dachsmate.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {

    Admin findForLoginPassword(String adminname,String adminPassword);
    Admin findAdminById(Integer id);
}
