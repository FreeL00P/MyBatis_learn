package com.fj.mybatis.test;

import com.fj.mybatis.mapper.DynamicSQLMapper;
import com.fj.mybatis.pojo.Emp;
import com.fj.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/17 15:27    since 1.0.0
 */
public class DynamicSQLMapperTest {
    /**
     * 动态SQL
     * if 根据标签中的test属性所对应的表达式决定标签中的内容是否需要拼接到SQL
     * where 当where标签中有内容时 会自动生成关键字 并且会将内容前多余的and or去掉
     * 当where标签没有内容时 没有任何效果 不会自动生成where关键字
     */
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empList = mapper.getEmpByConditionTwo(new Emp(null, "", 23, "", "123@qq.com"));
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }
    @Test
    public void testEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empList = mapper.getEmpByChoose(new Emp(null, "", 23, "", "123@qq.com"));
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }
    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println("result = " + result);
    }
    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1=new Emp(null, "a1", 23, "男", "123@qq.com");
        Emp emp2=new Emp(null, "a2", 23, "男", "123@qq.com");
        Emp emp3=new Emp(null, "a3", 23, "男", "123@qq.com");
        List<Emp> list = Arrays.asList(emp1, emp2, emp1);
        System.out.println(mapper.insertMoreByList(list));
    }
}
