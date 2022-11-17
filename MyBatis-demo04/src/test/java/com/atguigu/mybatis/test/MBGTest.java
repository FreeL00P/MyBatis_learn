package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/18 12:40    since 1.0.0
 */
public class MBGTest {
    @Test
    public void testMBG(){
        try {
            InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
//            List<Emp> empList = mapper.selectByExample(null);
//            for (Emp emp : empList) {
//                System.out.println("emp = " + emp);
//            }
            //根据条件查询
            EmpExample example=new EmpExample();
            example.createCriteria().andEmpNameEqualTo("a1").andAgeBetween(10,23);
            List<Emp> empList = mapper.selectByExample(example);
            for (Emp emp : empList) {
                System.out.println("emp = " + emp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
