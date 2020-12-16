package com.pc.netctoss.service;

import com.pc.netctoss.dao.ICostDAO;
import com.pc.netctoss.entity.Cost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Cost 服务层组件
 * @author: Peter
 * @date: 2020/12/11 22:05
 */
@Service
public class CostService {

//    @Resource(name = "costDAOImpl")
    @Resource(name = "jdbcCostDAOImpl")
    private ICostDAO costDAO;  // 此处因为只有 CostDAOImpl 类使用了 @Repository 注解，因此注入的是 CostDAOImpl 对象。

    public List<Cost> findAll(){
        return costDAO.findAll();
    }
}
