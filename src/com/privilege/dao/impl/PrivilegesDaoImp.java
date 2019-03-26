package com.privilege.dao.impl;

import com.privilege.dao.PrivilegesDao;
import com.privilege.po.Privileges;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PrivilegesDaoImp implements PrivilegesDao {
    private QueryRunner queryRunner = C3P0Util.getqueryRunner();
    @Override
    public List<Privileges> getPrivilegeList(int roleid) {
        String sql = "select * from \"privileges\" where \"id\"  in(select \"privilege_id\" from \"roleprivilege\" where \"role_id\"=?)";

        List<Privileges> privilegeList=null;
        try {
            privilegeList = queryRunner.query(sql, new BeanListHandler<Privileges>(Privileges.class), roleid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privilegeList;
    }

    @Override
    public List<Privileges> getPrivilegeLists(int roleid) {
        String sql="select * from \"privileges\" where \"id\"  not in(select \"privilege_id\" from \"roleprivilege\" where \"role_id\"=?)";
        List<Privileges> privilegesList=null;
        try {
            privilegesList = queryRunner.query(sql, new BeanListHandler<Privileges>(Privileges.class),roleid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privilegesList;
    }

    @Override
    public int deletePrivilegesByRoleid(String[] deleteroleids) {

        return 0;
    }

    @Override
    public int addPrivilegesByRoleid(String[] addroleids) {

        return 0;
    }

    @Override
    public int addPrivilege(Privileges privilege) {
        String sql = "INSERT INTO \"privileges\" VALUES(id.nextval,?,?,?)";
        int row=0;
        try {
            row = queryRunner.update(sql, privilege.getName(), privilege.getFnpath(), privilege.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<Privileges> selectPrivilege() {
        String sql = "select * from \"privileges\"";
        List<Privileges> privilegesList = null;
        try {
            privilegesList = queryRunner.query(sql, new BeanListHandler<Privileges>(Privileges.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privilegesList;
    }

}
