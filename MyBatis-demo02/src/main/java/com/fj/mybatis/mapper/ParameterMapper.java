package com.fj.mybatis.mapper;

import com.fj.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Observable;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/15 21:23    since 1.0.0
 */
public interface ParameterMapper {
    //查询所有员工信息
    List<User> getAllUser();
    //根据用户名查询用户信息
    List<User> getUserByUserName(String username);
    //验证登陆
    User checkLogin(String username,String password);
    //验证登陆参数为map
    User checkLoginByMap(Map<String, Object> map);
    //添加用户信息
    int insertUser(User user);
    //验证登陆 使用@Param
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}
