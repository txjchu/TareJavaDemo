package com.pc.demo.annotation;

/**
 * spring+mybatis 整合方式二
 *
 * 自定义注解
 * 用来注解实体类的 mapper 接口，结合对应的 xml 来实现 mybatis 对数据库的操作
 *
 * 需要在 spring-confing.xml 中的 bean : org.mybatis.spring.mapper.MapperScannerConfigurer 中配置一个 property 声明注解类 annotationClass。
 * @author: Peter
 * @date: 2020/12/16 21:00
 */
public @interface MyBatisMapper {
}
