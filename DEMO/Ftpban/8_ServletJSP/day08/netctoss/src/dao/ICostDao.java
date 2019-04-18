package dao;

import java.util.List;
import entity.Cost;

/**
 *	1.DAO的经典写法是带有接口的，
 *	  至于接口的作用学Spring时就懂了。
 *  2.以I开头是一种规范，便于识别该接口。
 *   此规范看企业而定，未必都如此。
 */
public interface ICostDao {
	
	List<Cost> findAll();
	
	void save(Cost cost);
	
	Cost findById(int id);
	
	void update(Cost cost);

}





