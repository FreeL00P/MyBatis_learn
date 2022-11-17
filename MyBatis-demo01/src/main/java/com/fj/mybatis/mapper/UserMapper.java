package com.fj.mybatis.mapper;

import com.fj.mybatis.pojo.User;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/15 13:25    since 1.0.0
 */
public interface UserMapper {
    /**
     * MyBatis面向接口编程的两个一致
     * 1、映射文件的namespace要和mapper接口的全类名一致
     * 2、映射文件中SQL语句中的id要和mapper接口中的方法名一致
     */
    int insertUser();
    void updateUser();
    void deleteUser();
    User getUserById();
    List<User> getUser();
}
