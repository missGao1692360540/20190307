package com.privilege.controller;

import com.privilege.po.Privileges;
import com.privilege.service.PrivilegeService;
import com.privilege.service.impl.PrivilegeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/PrivilegeSerServlet.do")
public class PrivilegeSerServlet extends HttpServlet {
    PrivilegeService privilegeService = new PrivilegeServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取
        String choose = req.getParameter("choose");
        switch (choose){
            case "1":
                addPrivileg(req,resp);
            break;
            case "2":
                selectAllPrivilegs(req,resp);
            break;
    }



//        String roleid = req.getParameter("roleid");
//        req.getParameter("choose");
//        req.getParameter("privilegedeleteid").split(",");
//        String[] privilegeaddids = req.getParameter("privi1legeaddid").split(",");
//        req.getParameter("privilegedeleteid");

    }

    //查看权限
    private void selectAllPrivilegs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Privileges> privilegesList = privilegeService.selectPrivilege();
        HttpSession session = req.getSession();
        session.setAttribute("privilegesList",privilegesList);
        req.getRequestDispatcher("/jsp/privilege_list.jsp").forward(req,resp);
    }

    //添加权限
    private void addPrivileg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取
        String pname = req.getParameter("p_name");
        String purl = req.getParameter("p_url");
        String pdescription = req.getParameter("p_description");
        //调
        Privileges privilege = new Privileges(0,pname,purl,pdescription);
        int row = privilegeService.addPrivilege(privilege);
        if (row>0){
            req.getRequestDispatcher("/jsp/addsucceed.jsp").forward(req,resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
