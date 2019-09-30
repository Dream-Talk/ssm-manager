package com.personal.service;

import com.personal.domain.SysLog;

import java.util.List;

public interface ISysLogService  {
    /**
     * 查找所有日志
     */
    List<SysLog> findAll() throws Exception;
    /**
     * 保存日志
     */
    void save(SysLog sysLog) throws Exception;
}
