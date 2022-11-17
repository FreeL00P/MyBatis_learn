package com.fj.mybatis.test;

import com.fj.mybatis.mapper.UserMapper;
import com.fj.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/15 13:45    since 1.0.0
 */
public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SQLSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //获取SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession 开启自动提交事务
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //测试功能
        int result = mapper.insertUser();
        //sqlSession.commit();
        System.out.println("result = " + result);
    }
    @Test
    public void testCRUD() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SQLSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //获取SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession 开启自动提交事务
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //mapper.updateUser();
        //mapper.deleteUser();
        //User user = mapper.getUserById();
        List<User> userList = mapper.getUser();
        for (User user : userList) {
            System.out.println("user = " + user);
        }

    }
}
