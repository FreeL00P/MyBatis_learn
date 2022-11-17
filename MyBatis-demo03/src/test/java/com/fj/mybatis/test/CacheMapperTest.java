package com.fj.mybatis.test;

import com.fj.mybatis.mapper.CacheMapper;
import com.fj.mybatis.pojo.Emp;
import com.fj.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/17 21:52    since 1.0.0
 */
public class CacheMapperTest {
    @Test
    public void testCache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpByEid(16);
        System.out.println(emp);
    }
    @Test
    public void testCache2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpByEid(16);
        System.out.println(emp);
        //mapper.insertEmp(new Emp(null,"aa",23,"男","123@qq.com"));
        sqlSession.clearCache();
        Emp emp1 = mapper.getEmpByEid(16);
        System.out.println(emp1);
    }
    @Test
    public void testTwoCache(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession1= sqlSessionFactory.openSession(true);
            CacheMapper mapper1= sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(16));
            sqlSession1.close();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2= sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(16));
            sqlSession1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
