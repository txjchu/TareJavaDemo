package dao;

import entity.Cost;

import java.util.List;

/**
 *	1.DAO的经典写法是带有接口的， 至于接口的作用学Spring时就懂了。
 *  2.以I开头是一种规范，便于识别该接口。 此规范看企业而定，未必都如此。
 *
 * @author: Peter
 * @date: 2020/11/19 23:28
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
