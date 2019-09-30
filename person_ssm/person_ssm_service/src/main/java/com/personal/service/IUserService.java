package com.personal.service;

import com.personal.domain.Role;
import com.personal.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService  extends UserDetailsService {

    /**
     * 查询所有用户
     */
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo info) throws Exception;

    UserInfo findUserById(String userId) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
