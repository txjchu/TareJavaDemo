package com.pc.netctoss.dao;

import com.pc.netctoss.entity.Cost;

import java.util.List;

/**
 * Cost DAO 接口
 * @author: Peter
 * @date: 2020/12/11 21:55
 */
public interface ICostDAO {

    List<Cost> findAll();
    Cost findById(Integer costId);
    void save(Cost cost);
    void update(Cost cost);
    void delete(Integer costId);
    Cost findByName(String name);
    void updateStatus(Cost cost);
}
