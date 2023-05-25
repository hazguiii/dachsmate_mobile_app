package com.dachsmate.services.impl;

import com.dachsmate.dao.AdminDao;
import com.dachsmate.entity.Admin;
import com.dachsmate.services.AdminService;
import com.dachsmate.services.UserService;
import com.dachsmate.views.AdminView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public Admin findAdminForLoginPassword(String name, String password) {

        return adminDao.findForLoginPassword(name, password);
    }

    @Override
    public Admin findAdminById(Integer id) {
        return adminDao.findAdminById(id);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminDao.save(Admin.newInstance(admin));
    }

    @Override
    public Admin updateAdmin(Admin admin, AdminView adminView) {

        admin.setPassword(adminView.getPassword());
        admin.setName(adminView.getName());
        admin.setEmail(adminView.getEmail());


        adminDao.saveAndFlush(admin);
        return admin;
    }

    @Override
    public List<Admin> findAllAdmins() {
        return adminDao.findAll();
    }

    @Override
    public String deleteAdmin(Admin admin) {
        adminDao.delete(admin);
        return "ok";
    }
}
