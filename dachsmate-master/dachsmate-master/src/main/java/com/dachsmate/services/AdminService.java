package com.dachsmate.services;

import com.dachsmate.entity.Admin;
import com.dachsmate.views.AdminView;

import java.util.List;

public interface AdminService {

    Admin findAdminForLoginPassword(String adminname, String adminPassword);

    Admin findAdminById(Integer id);

    Admin saveAdmin(Admin admin);

    Admin updateAdmin(Admin admin, AdminView adminView);

    String deleteAdmin(Admin admin);

    List<Admin> findAllAdmins();
}
