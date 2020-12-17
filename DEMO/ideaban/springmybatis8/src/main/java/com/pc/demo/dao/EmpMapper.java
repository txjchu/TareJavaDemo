package com.pc.demo.dao;

import com.pc.demo.annotation.MyBatisMapper;
import com.pc.demo.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/16 20:37
 */
@MyBatisMapper
@Repository
public interface EmpMapper {

    List<Emp> findAll();

    Emp findById(Integer empno);
    void update(Emp emp);

}
