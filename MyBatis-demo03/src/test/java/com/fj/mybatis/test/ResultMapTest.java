package com.fj.mybatis.test;

import com.fj.mybatis.mapper.DeptMapper;
import com.fj.mybatis.mapper.EmpMapper;
import com.fj.mybatis.pojo.Dept;
import com.fj.mybatis.pojo.Emp;
import com.fj.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/16 21:48    since 1.0.0
 */
public class ResultMapTest {
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = mapper.getAllEmp();
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(1);
        System.out.println("empAndDept = " + empAndDept);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDeptBySeptOne(1);
        System.out.println("empAndDept = " + empAndDept.getEmpName());
    }
    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }
}
