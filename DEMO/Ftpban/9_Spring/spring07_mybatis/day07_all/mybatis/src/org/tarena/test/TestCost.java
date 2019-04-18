package org.tarena.test;

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
	public void testMap(){
		SqlSession session = 
			MyBatisUtil.getSqlSession();
		
		Map<String,Object> map = 
			session.selectOne("findNameById",1);
		System.out.println(map.get("COST_ID"));
		System.out.println(map.get("NAME"));
		
		session.close();
	}
	
	@Test
	public void testDelete(){
		SqlSession session = 
			MyBatisUtil.getSqlSession();
		
		session.delete("delete",121);//��id=delete
		session.commit();//�ύ
		
		session.close();
	}
	
	@Test
	public void testStart(){
		SqlSession session = 
			MyBatisUtil.getSqlSession();
		
		Map<String,Object> params = 
			new HashMap<String, Object>();
		params.put("id", 1);//��ӦSQL��#{id}
		Date time = new Date(System.currentTimeMillis());
		params.put("startime", time);//��ӦSQL��#{startime}
		session.update("start",params);//ִ��update
		session.commit();//�ύ����
		
		session.close();
	}
	
	@Test
	public void testSave(){
		SqlSession session = 
			MyBatisUtil.getSqlSession();
		Cost cost = new Cost();
		cost.setBase_duration(0L);//��ʼ��
		cost.setBase_cost(0.0);//��ʼ��
		cost.setName("2016��ʱA");
		cost.setUnit_cost(0.5);
		cost.setDescr("��1Сʱ��0.2Ԫ");
		cost.setStatus("0");
		cost.setCost_type("1");
		Date time = new Date(
			System.currentTimeMillis());
		cost.setCreatime(time);
		session.insert("save",cost);//<insert id="save">
		session.commit();//��ɾ����Ҫ�ύ����
		session.close();
	}
	
	@Test
	public void testFindById(){
		SqlSession session = 
			MyBatisUtil.getSqlSession();
		Cost cost = session.selectOne(
				"findById",4);
		System.out.println(cost.getName());
		System.out.println(cost.getDescr());
		session.close();
	}
	
	@Test
	public void testFindAll(){
		SqlSession session = 
			MyBatisUtil.getSqlSession();
		List<Cost> list = 
			session.selectList("findAll");//id��
		for(Cost cost : list){
			System.out.println(
				cost.getCost_id()+" "+cost.getName());
		}
	}
	
}
