package com.privilege.dao.impl;

import com.privilege.dao.UserDao;
import com.privilege.po.User;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    //获取C3P0的操作对象
    private QueryRunner queryRunner = C3P0Util.getqueryRunner();
    @Override
    public int login(String username, String password)  {
        String sql = "select  count(*) from users where username=? and password=?";
        Long count = 0l;
        try {
            count = (Long)queryRunner.query(sql,new ScalarHandler(1),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count.intValue();
    }

    @Override
    public int addUser(User user) {
        String sql = "INSERT INTO users VALUES(null,?,?,?)";
        int rows = 0;
        try {
            rows = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getNickname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int updatepass(int id,String pass) {
        String sql = "UPDATE users SET PASSWORD=? WHERE id=?";
        int row = 0;
        try {
            row = queryRunner.update(sql,pass,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
