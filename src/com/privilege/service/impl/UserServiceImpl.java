package com.privilege.service.impl;

import com.privilege.dao.UserDao;
import com.privilege.dao.impl.UserDaoImpl;
import com.privilege.po.User;
import com.privilege.service.UserService;
import com.privilege.utils.MD5Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public int login(String username, String password) {

        //密码加密
        password = MD5Util.MD5Encoding(password);
        System.out.println(password);
        int rows = 0;
        try {
            rows = userDao.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int addUser(User user) {
        int row = userDao.addUser(user);
        return row;
    }

    @Override
    public int updatepass(int id,String pass) {
        int row = userDao.updatepass(id,pass);
        return row;
    }
}
