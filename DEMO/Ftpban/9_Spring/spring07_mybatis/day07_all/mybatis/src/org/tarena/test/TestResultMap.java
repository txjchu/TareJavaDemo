package org.tarena.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.tarena.entity.MyCost;
import org.tarena.util.MyBatisUtil;

public class TestResultMap {
	@Test
	public void testResultMap(){
		SqlSession session = 
			MyBatisUtil.getSqlSession();
	
		List<MyCost> list = 
			session.selectList("findMyCost1");
		for(MyCost c : list){
			System.out.println(c.getId()+" "
				+c.getName()+" "+c.getUnitcost());
		}
		
		session.close();
	}
}
