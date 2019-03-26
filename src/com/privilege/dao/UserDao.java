package com.privilege.dao;

import com.privilege.po.User;

import java.sql.SQLException;

public interface UserDao {
    int login(String username,String password) ;
    int addUser(User user);
    int updatepass(int id,String pass);
}
