package com.pc.netctoss.dao;

import com.pc.netctoss.annotation.MyBatisRepository;
import com.pc.netctoss.entity.Cost;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/17 2:35
 */
@MyBatisRepository
@Repository
public interface CostMapper {

    List<Cost> findAll();
    Cost findById(Integer costId);


}
