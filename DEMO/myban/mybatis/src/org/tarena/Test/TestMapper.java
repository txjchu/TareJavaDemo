package org.tarena.Test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.tarena.dao.CostDao;
import org.tarena.entity.Cost;
import org.tarena.util.MyBatisUtil;

public class TestMapper {
	@Test
	public void testMapper(){
		SqlSession session = MyBatisUtil.getSqlSession();
		CostDao costDao = session.getMapper(CostDao.class); //----自动获取CostDao对象，相当于自动产生实现类。
		System.out.println(costDao.getClass().getName()); 	//----类的反射，此行得到的是生成类的动态名称
		List<Cost> list = costDao.findAll();
		for(Cost cost:list){
			System.out.println(cost.getCost_id()+"  "+cost.getName());
		}
//		Cost cost = costDao.findById(1);
//		System.out.println(cost.getName());
		session.close();
	}
}
