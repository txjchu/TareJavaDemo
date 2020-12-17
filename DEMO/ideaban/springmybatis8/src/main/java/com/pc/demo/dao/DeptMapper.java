package com.pc.demo.dao;

import com.pc.demo.annotation.MyBatisMapper;
import com.pc.demo.entity.Dept;

import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/16 21:07
 */
@MyBatisMapper
public interface DeptMapper {


    List<Dept> findAll();
    Dept findById(Integer deptno);
    void save(Dept dept);
    void update(Dept dept);
    void delete(Integer deptno);

}
