package com.pc.service;

import com.pc.dao.IEmpDAO;
import com.pc.entity.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Emp 的 service 组件
 * @author: Peter
 * @date: 2020/12/13 1:20
 */
@Service
public class EmpService implements Serializable {

    @Resource
    private IEmpDAO empDAO;

    public List<Emp> findAll(){
        return empDAO.findAll();
    }

    public Emp findById(int id){
        return empDAO.findById(id);
    }

    public void updateEmp(Emp emp){
        empDAO.update(emp);
    }

    public void deleteEmp(Integer id){
        empDAO.delete(id);
    }

    public void addEmp(Emp emp){
        empDAO.save(emp);
    }
}
