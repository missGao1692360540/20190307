package com.privilege.controller;

import com.privilege.dao.UserDao;
import com.privilege.po.Roles;
import com.privilege.service.RolesService;
import com.privilege.service.UserService;
import com.privilege.service.impl.RolesServiceImpl;
import com.privilege.service.impl.UserServiceImpl;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        RolesService rolesService = new RolesServiceImpl();
        UserService userService = new UserServiceImpl();
        int login = userService.login("admin", "YWRtaW4=");
        System.out.println(login);
    }
}
