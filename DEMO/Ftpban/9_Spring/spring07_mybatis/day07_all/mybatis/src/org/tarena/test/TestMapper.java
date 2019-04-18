package org.tarena.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.tarena.dao.CostDao;
import org.tarena.entity.Cost;
import org.tarena.util.MyBatisUtil;

public class TestMapper {

	@Test
	public void testMapper(){
		SqlSession session = 
			MyBatisUtil.getSqlSession();
		
		CostDao costDao = 
			session.getMapper(CostDao.class);
		System.out.println(costDao.getClass().getName());
//		List<Cost> list = costDao.findAll(); 
//		for(Cost cost : list){
//			System.out.println(
//				cost.getCost_id()+" "+cost.getName());
//		}
		Cost cost = costDao.findById(1);
		System.out.println(cost.getName());
		session.close();
	}
	
}
