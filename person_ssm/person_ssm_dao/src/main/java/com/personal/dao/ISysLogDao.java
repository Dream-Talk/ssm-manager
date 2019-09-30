package com.personal.dao;

import com.personal.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {
    /**
     * 查找所有日志
     */
    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;
    /**
     * 保存日志信息
     */

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;
}
