package com.fj.mybatis.mapper;

import com.fj.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/16 21:44    since 1.0.0
 */
public interface DeptMapper {
     Dept getEmpAndDeptAndStepTwo(@Param("did") Integer did);
     //获取部门以及部门中所有的员工信息
     Dept getDeptAndEmp(@Param("did") Integer did);
     //通过分步查询 查询部门以及对应的员工信息
     // 第一步查询部门信息
     Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
