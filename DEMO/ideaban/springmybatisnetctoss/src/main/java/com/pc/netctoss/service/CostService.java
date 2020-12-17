package com.pc.netctoss.service;

import com.pc.netctoss.dao.CostMapper;
import com.pc.netctoss.entity.Cost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Cost 的 service
 * @author: Peter
 * @date: 2020/12/17 2:54
 */
@Service
public class CostService implements Serializable {

    @Resource
    private CostMapper costMapper;

    public List<Cost> findAll(){
        return costMapper.findAll();
    }

}
