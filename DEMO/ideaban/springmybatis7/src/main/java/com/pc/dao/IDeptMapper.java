package com.pc.dao;

import com.pc.entity.Dept;

import java.util.List;

/**
 * Dept 的 mapper 接口
 * @author: Peter
 * @date: 2020/12/16 5:14
 */
public interface IDeptMapper {

    List<Dept> findAll();
    Dept findById(Integer deptno);
    void save(Dept dept);
    void update(Dept dept);
    void delete(Integer deptno);
}
