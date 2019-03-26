package com.privilege.controller;

import com.privilege.po.User;
import com.privilege.service.UserService;
import com.privilege.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserServlet.do")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choose = req.getParameter("choose");
        switch (choose){
            case "1":
                login(req,resp);
            break;
            case "2":
                addUser(req,resp);
            break;
            case "3":
                updatepass(req,resp);
            break;
            default:
                System.out.println("操作有误");
            break;
        }
    }

    private void updatepass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");
        int row = userService.updatepass(id, password);
        if(row>0){
            req.getRequestDispatcher("/jsp/updatasucceed.jsp").forward(req,resp);
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        User user = new User(0,username,password,nickname);
        int row = userService.addUser(user);
        if (row>0){
            req.getRequestDispatcher("/jsp/addsucceed.jsp").forward(req,resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //取
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调
        int rows = userService.login(username, password);
        if (rows>0){
            //存
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            //转
            req.getRequestDispatcher("/jsp/welcome.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
