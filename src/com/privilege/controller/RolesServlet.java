package com.privilege.controller;

import com.privilege.po.Privileges;
import com.privilege.po.Roles;
import com.privilege.service.PrivilegeService;
import com.privilege.service.RolesService;
import com.privilege.service.impl.PrivilegeServiceImp;
import com.privilege.service.impl.RolesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/RolesServlet.do")
public class RolesServlet extends HttpServlet {
    private RolesService rolesService = new RolesServiceImpl();
    private PrivilegeService privilegeService = new PrivilegeServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取
        String choose = req.getParameter("choose");
        switch (choose){
            case "1":
                selectRolesList(req,resp);
            break;
            case "2":
                seleprivilege(req,resp);
            break;
            case "3":
                addRoleList(req,resp);
            break;
            default:
                System.out.println("操作有误");
            break;
        }

    }

    private void addRoleList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Roles role = new Roles(0,name,description);
        int row = rolesService.addRole(role);
        if(row>0){
            req.getRequestDispatcher("/jsp/addsucceed.jsp").forward(req,resp);
        }
    }

    //调用查询权限的方法
    private void seleprivilege(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收角色名称
        String rolename = req.getParameter("rolename");
        int roleid = Integer.parseInt(req.getParameter("roleid"));
        //调用根据roleid查询已经权限的方法
        List<Privileges> privilegeList = privilegeService.getPrivilegeList(roleid);
        List<Privileges> privilegesList = privilegeService.getPrivilegeLists(roleid);
       //存
        HttpSession session = req.getSession();
        session.setAttribute("rolename",rolename);
        session.setAttribute("roleid",roleid);
        session.setAttribute("privilegeList",privilegeList);
        session.setAttribute("privilegesList",privilegesList);

        req.getRequestDispatcher("/jsp/grant_privilege.jsp").forward(req,resp);


    }

    private void selectRolesList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有角色
        List<Roles> rolesList = rolesService.selectRoles();
        //存
        HttpSession session = req.getSession();
        session.setAttribute("rolesList",rolesList);
        //转
        req.getRequestDispatcher("/jsp/roles_list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
