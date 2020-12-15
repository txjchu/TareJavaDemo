package com.pc.dao;

import com.pc.entity.Emp;

import java.util.List;

/**
 * Emp DAO 接口
 * @author: Peter
 * @date: 2020/12/12 21:46
 */
public interface IEmpDAO {

    List<Emp> findAll() ;

    Emp findById(Integer id);

    Emp findByEname(String ename);

    void save(Emp emp);

    void update(Emp emp);

    void delete(Integer id);
}
