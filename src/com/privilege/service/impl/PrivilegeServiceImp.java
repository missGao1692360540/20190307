package com.privilege.service.impl;

import com.privilege.dao.PrivilegesDao;
import com.privilege.dao.impl.PrivilegesDaoImp;
import com.privilege.po.Privileges;
import com.privilege.service.PrivilegeService;

import java.util.List;

public class PrivilegeServiceImp implements PrivilegeService {
    private PrivilegesDao privilegesDao = new PrivilegesDaoImp();
    @Override
    public List<Privileges> getPrivilegeList(int roleid) {

        List<Privileges> privilegeList = privilegesDao.getPrivilegeList(roleid);

        return privilegeList;
    }

    @Override
    public List<Privileges> getPrivilegeLists(int roleid) {
        List<Privileges> privilegesList = privilegesDao.getPrivilegeLists(roleid);
        return privilegesList;
    }

    @Override
    public List<Privileges> selectPrivilege() {
        List<Privileges> privilegesList = privilegesDao.selectPrivilege();
        return privilegesList;
    }

    @Override
    public int addPrivilege(Privileges privilege) {
        int row = privilegesDao.addPrivilege(privilege);
        return row;
    }
}
