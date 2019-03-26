package com.privilege.controller;

import com.privilege.po.Roles;
import com.privilege.service.RolesService;
import com.privilege.service.impl.RolesServiceImpl;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        RolesService rolesService = new RolesServiceImpl();
        List<Roles> roles = rolesService.selectRoles();
        for (Roles roles1:roles) {
            System.out.println(roles1);
        }
    }
}
