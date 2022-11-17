package com.fj.mybatis.test.test;

import com.fj.mybatis.mapper.SQLMapper;
import com.fj.mybatis.pojo.User;
import com.fj.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/16 20:30    since 1.0.0
 */
public class SQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> userList = mapper.getUserByLike("a");
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testDeleteMore(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("6,7,8");
        System.out.println("result = " + result);
    }
    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> userList = mapper.getUserByTableName("t_user");
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "root", "password", 23, "男", "1243423@gmail.com");
        mapper.insertUser(user);
        System.out.println("user = " + user);

    }
}
