package com.privilege.service;

import com.privilege.po.Privileges;

import java.util.List;

public interface PrivilegeService {
    //授权
    List<Privileges> getPrivilegeList(int roleid);
    List<Privileges> getPrivilegeLists(int roleid);

    List<Privileges> selectPrivilege();

    int addPrivilege(Privileges privilege);
}
