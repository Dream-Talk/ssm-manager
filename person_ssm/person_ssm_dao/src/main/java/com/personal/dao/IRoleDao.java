package com.personal.dao;

import com.personal.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id",javaType = java.util.List.class,many = @Many(select="com.personal.dao.IPermissionDao.findPerByRoleId"))
    })
    List<Role> findRoleByUserId(String userId)throws Exception;

    @Select("select * from role")
    List<Role> findAll();

   @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;
}
