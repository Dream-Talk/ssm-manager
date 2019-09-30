package com.personal.service.impl;

import com.personal.dao.IPermissionDao;
import com.personal.domain.Permission;
import com.personal.service.IPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionImpl implements IPermission {
    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }
}
