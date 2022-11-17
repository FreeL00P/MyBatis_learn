package com.fj.mybatis.mapper;

import com.fj.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/16 15:17    since 1.0.0
 */
public interface SelectMapper {
    User getUserById(@Param("id") Integer id);
    Integer getCount();
    //根据id查询用户信息返回一个map集合
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
    //List<Map<String,Object>> getUserToMap();
    @MapKey("id")
    Map<String,Object> getUserToMap();
}
