package com.personal.service;

import com.personal.domain.Permission;

import java.util.List;

public interface IPermission {
    /**
     *查询所有
     */
    List<Permission> findAll();

}
