package com.privilege.dao.impl;

import com.privilege.dao.RolesDao;
import com.privilege.po.Roles;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RolesDaoImpl implements RolesDao {
    private QueryRunner queryRunner = C3P0Util.getqueryRunner();
    @Override
    public List<Roles> selectRoles() {
        String sql = "select * from \"roles\"";
        List<Roles> rolesList = null;
        try {
            rolesList = queryRunner.query(sql, new BeanListHandler<Roles>(Roles.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rolesList;
    }

    @Override
    public int addRole(Roles role) {
        String sql = "INSERT INTO roles VALUES(null,?,?)";
        int row = 0;
        try {
            row = queryRunner.update(sql, role.getName(), role.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }


}
