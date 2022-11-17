package com.fj.mybatis.mapper;

import com.fj.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/16 20:24    since 1.0.0
 */
public interface SQLMapper {
    //根据用户名模糊查询用户信息
    List<User> getUserByLike(@Param("username") String username);
    //批量删除
    int deleteMore(@Param("ids") String ids);
    //根据表明查找用户信息
    List<User>  getUserByTableName(@Param("tableName") String tableName);
    //添加用户信息
    void insertUser(User user);
}
