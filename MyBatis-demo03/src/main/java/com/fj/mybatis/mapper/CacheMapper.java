package com.fj.mybatis.mapper;

import com.fj.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/17 21:47    since 1.0.0
 */
public interface CacheMapper {
    //
    Emp getEmpByEid(@Param("eid") Integer eid);
    void insertEmp(Emp emp);
}
