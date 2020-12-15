package com.pc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis 工具类
 * @author: Peter
 * @date: 2020/12/16 2:25
 */
public class MyBatisUtil {

    // 获取 SQL session
    private static SqlSessionFactory sqlSessionFactory;

    // 加载配置文件，初始化 sqlSessionFactory
    static {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 SQLSession
     * @return
     */
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }


    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSession();
        System.out.println("MyBatisUtil-"+ Thread.currentThread().getStackTrace()[1].getMethodName() +": "+ sqlSession);
    }

}
