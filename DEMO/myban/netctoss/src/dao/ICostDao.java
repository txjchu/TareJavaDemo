package dao;

import java.util.List;

import entity.Cost;

/**
 * 1.Dao的经典写法是带有接口的。至于接口的作用学Spring时就懂了。
 * 2.以I开头的类和接口是一种规范，便于识别该接口，此规范看企业而定，未必都如此。
 * @author Administrator
 *
 */
public interface ICostDao {
	List<Cost> findAll();
	
	//声明一个保存的方法
	void save(Cost cost);
	//声明一个修改用的查询方法
	Cost findById(int id);
	//声明一个修改方法
	void update(Cost cost);
	
}
