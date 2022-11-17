package com.fj.mybatis.mapper;

import com.fj.mybatis.pojo.Dept;
import com.fj.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/16 21:44    since 1.0.0
 */
public interface EmpMapper {
    //查询所有员工信息
    List<Emp> getAllEmp();
    //查询员工一级员工对应的部门信息
    Emp getEmpAndDept(@Param("eid") Integer eid);
    //通过分步查询查询员工以及员工对应的部门信息
    Emp getEmpAndDeptBySeptOne(@Param("eid") Integer eid);
    //通过分步查询 查询部门以及对应的员工信息
    // 第二步查询员工信息
    Emp getDeptAndEmpByStepTwo(@Param("eid") Integer eid);
}
