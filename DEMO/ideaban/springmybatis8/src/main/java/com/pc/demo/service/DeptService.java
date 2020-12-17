package com.pc.demo.service;

import com.pc.demo.dao.DeptMapper;
import com.pc.demo.entity.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/17 23:03
 */
@Service
public class DeptService implements Serializable {

    @Resource
    private DeptMapper mapper;

    public List<Dept> findAll(){
        return mapper.findAll();
    }
}
