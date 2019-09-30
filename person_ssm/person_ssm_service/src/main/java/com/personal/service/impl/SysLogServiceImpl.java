package com.personal.service.impl;

import com.personal.dao.ISysLogDao;
import com.personal.domain.SysLog;
import com.personal.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysLogServiceImpl  implements ISysLogService{

    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}
