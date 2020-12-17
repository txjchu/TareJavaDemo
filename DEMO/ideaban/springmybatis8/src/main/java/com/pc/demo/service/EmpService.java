package com.pc.demo.service;

import com.pc.demo.dao.EmpMapper;
import com.pc.demo.entity.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/16 21:47
 */
@Service
public class EmpService implements Serializable {

    @Resource
    private EmpMapper mapper;



    public List<Emp> findAll(){
        return mapper.findAll();
    }

    public Emp findById(Integer empno){
        return mapper.findById(empno);
    }

    public void update(Emp emp){
        mapper.update(emp);
    }
}
