package com.dachsmate.controller;

import com.dachsmate.dao.AdminDao;
import com.dachsmate.entity.Admin;
import com.dachsmate.services.AdminService;
import com.dachsmate.views.AdminView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = AdminController.MAIN)
public class AdminController {

    @Autowired
    AdminService adminService;

    public static final String MAIN = "api/main";
    public static final String MAIN_ADMIN = "/admin";
    //  public static final String MAIN_ADMIN = "/admin";
    //  public static final String MAIN_CARD = "/card";

    // Request mapping names

    public static final String ADMIN_LOGIN = "/login";
    public static final String ADMIN_NEW = "/newAdmin";
    public static final String ADMIN_UPDATE = "/updateAdmin";
    public static final String ADMIN_DELETE = "/deleteAdmin";
    public static final String ADMIN_LIST = "/admins";


    @RequestMapping(value = "getAllAdmins", method = RequestMethod.GET)
    public List<Admin> getAllAdmins(){
        return adminService.findAllAdmins();
    }
    @RequestMapping(value = "addAdmin", method = RequestMethod.POST)
    public void addAdmin(@RequestBody Admin admin){
        System.out.println(admin.toString());
        adminService.saveAdmin(admin);
    }
    @PostMapping(MAIN_ADMIN + ADMIN_LOGIN)
    public Admin login(@RequestBody AdminView adminView) {

        Admin admin = adminService.findAdminForLoginPassword(adminView.getName(), adminView.getPassword());
        return admin;
    }

    @PostMapping(MAIN_ADMIN + ADMIN_NEW)
    public Admin createAdmin(@RequestBody Admin adminView) {
        Admin admin = adminService.saveAdmin(adminView);
        return admin;
    }

    @PostMapping(MAIN_ADMIN + ADMIN_UPDATE)
    public Admin updateAdmin(@RequestBody AdminView adminView) {
        Admin admin = adminService.findAdminById(adminView.getId());
        if (admin != null) {
            return adminService.updateAdmin(admin, adminView);
        } else {
            return null;
        }
    }

    @PostMapping(MAIN_ADMIN + ADMIN_DELETE)
    public String deleteAdmin(@RequestBody AdminView adminView) {
        Admin admin = adminService.findAdminById(adminView.getId());
        if (admin != null) {
            return adminService.deleteAdmin(admin);
        } else {
            return "ERROR";
        }
    }

    @GetMapping(MAIN_ADMIN + ADMIN_LIST)
    public List<Admin> updateAdmin() {
        return adminService.findAllAdmins();
    }

}
