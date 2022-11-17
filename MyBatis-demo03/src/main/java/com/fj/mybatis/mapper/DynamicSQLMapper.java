package com.fj.mybatis.mapper;

import com.fj.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/17 15:16    since 1.0.0
 */
public interface DynamicSQLMapper {
    //多条件查询
    List<Emp> getEmpByCondition(Emp emp);
    List<Emp> getEmpByConditionTwo(Emp emp);
    List<Emp> getEmpByChoose(Emp emp);
    //通过数组实现批量删除
    int deleteMoreByArray(@Param("eids") Integer[] eids);
    //通过list集合实现批量添加
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
