package com.personal.dao;

import com.personal.domain.Role;
import com.personal.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    /**
     * 根据用户名查询出整个用户信息并封装在userInfo中
     */
    @Select("select * from users where username=#{userName}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.personal.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String userName);

    /**
     * 查询所有用户
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 添加一个用户
     */
    @Insert("insert into users(username,email,password,phoneNum,status)" +
            "values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo info);

    /**
     *根据用户id查询用户详情
     */
    @Select("select * from users where id=#{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.personal.dao.IRoleDao.findRoleByUserId"))
            })
    UserInfo findUserById(String userId) throws Exception;
    /**
     * 根据用户id查询其未拥有的角色
     */
    @Select("select * from role where id not in (select roleId from users_role where userid=#{userId})")
    List<Role>findOtherRoles(String userId) throws Exception;

    /**
     *
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId")String roleId) throws Exception;
}
