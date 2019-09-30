package com.personal.service;

import com.personal.domain.Role;

import java.util.List;

public interface IRoleService {
    /**
     *查询所有
     */
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;
}
