package org.tarena.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.tarena.entity.Cost;
import org.tarena.util.MyBatisUtil;

public class TestCost {
	@Test
	public void testFindAll(){
		SqlSession session = MyBatisUtil.getSqlSession();
		List<Cost> list = session.selectList("findAll");		//id名
		for(Cost cost:list){
			System.out.println(
					cost.getCost_id()+" "+cost.getName()+""+cost.getDescr()+""+cost.getStatus()+""+cost.getBase_cost()+""+cost.getBase_duration()+""+cost.getCreatime()+""+cost.getStartime()+"");			
		}
	}
	@Test
	public void testFindById(){
		SqlSession session = MyBatisUtil.getSqlSession();
		Cost cost = session.selectOne("findById",140);
		System.out.println(cost.getName());
		System.out.println(cost.getDescr());
		System.out.println(cost.getCost_type());
		session.close();
	}
	@Test
	public void testFindByName(){
		SqlSession session = MyBatisUtil.getSqlSession();
		Cost cost = session.selectOne("findByName","2016计时");
//		List<Cost> cost= session.selectList("findByName", "2016计时");
//		System.err.println(cost.);
		System.out.println(cost.getName());
		System.out.println(cost.getDescr());
		System.out.println(cost.getStatus());
		System.out.println(cost.getCost_id());
		System.out.println(cost.getBase_duration());
		session.close();
	}
	@Test
	public void testSave(){
		SqlSession session = MyBatisUtil.getSqlSession();
		Cost cost = new Cost();
		cost.setBase_duration(0L);	//初始化
		cost.setBase_cost(0.0);		//初始化
		cost.setName("2016计时");
		cost.setUnit_cost(0.5);
		cost.setDescr("用1小时收费0.5元。");
		cost.setStatus("0");
		cost.setCost_type("1");
		Date time = new Date(System.currentTimeMillis());	//sql中的Date类型，需要参数赋值----将当前系统时间赋值给time
		cost.setCreatime(time);
//		cost.setStartime(time);
		session.insert("save",cost);		//<insert id="save">
		session.commit();					//----增删改需要提交事务
		session.close();
	}
	@Test
	public void testStart(){
		SqlSession session = MyBatisUtil.getSqlSession();
		Map<String ,Object> params = new HashMap<String,Object>();
		params.put("id", 1);	//对应SQL中#{id}
		Date time = new Date(System.currentTimeMillis());
		params.put("startime", time);	//对应SQL中#{startime}
		session.update("start", params);//执行update
		session.commit();				//提交事务										
		session.close();
	}
	
	@Test
	public void testDelete(){
		SqlSession session = MyBatisUtil.getSqlSession();
		session.delete("delete",140);
		session.commit();
		session.close();
			
	}
	@Test
	public void testMap(){
		SqlSession session = MyBatisUtil.getSqlSession();
		Map<String,Object> map = session.selectOne("findNameById", 1);
		System.out.println(map.get("COST_ID"));
		System.out.println(map.get("NAME"));
		session.close();
	}
}
