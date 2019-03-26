package com.privilege.dao;

import com.privilege.po.Privileges;

import java.util.List;

public interface PrivilegesDao {

    List<Privileges> getPrivilegeList(int roleid);
    List<Privileges> getPrivilegeLists(int roleid);

    int deletePrivilegesByRoleid(String[] deleteroleids);
    int addPrivilegesByRoleid(String[] addroleids);

    int addPrivilege(Privileges privilege);
    List<Privileges> selectPrivilege();
}
