package com.personal.dao;

import com.personal.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionid from role_permission where roleid=#{roleId})")
    List<Permission> findPerByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> findAll();
}
