package com.tare.netctoss.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.netctoss.dao.CostDAO;
import com.tare.netctoss.dao.ICostDAO;
import com.tare.netctoss.entity.Cost;

/**
 * 测试类，测试CostDAO的中的方法
 * @author Administrator
 *
 */
public class TestCostDAO {
	
	private CostDAO dao = null;
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = ac.getBean(ICostDAO.class);
	}
	
	@Test
	public void testFindByName(){//测试按名字查找，即动态验证名字是否唯一
		List<Cost> costs = dao.findByName("大王卡19款");
		if(costs.size() != 0){
			for(Cost c : costs){
				System.out.println(c);
			}
						// actual 真实的目前的 	expected 预期的	positional 位置地位的 
		} else {
			System.out.println("名字可以使用！没有被注册过！");
		}
	}
	@Test
	public void testFindByPage(){
		int page = 3;//当前第几页
		int pageSize = 6;//每页记录数
		System.out.println("总共有："+ dao.findTotalPage(pageSize));
		List<Cost> costs = dao.findByPage(page, pageSize);
		System.out.println("-----------");
		for(Cost cost : costs){
			System.out.println(cost);
		}
	}
	@Test
	public void testFindAll(){
		List<Cost> costs = dao.findAll();
		for(Cost cost : costs){
			System.out.println(cost);
		}
	}
	@Test
	public void testFindById(){
		Cost cost = dao.findById(1);
		System.out.println(cost);
	}
	@Test
	public void testAdd(){
		for(int i = 0; i < 50; i ++){
			Cost cost = dao.findById(100);
			cost.setName("大王卡"+ i +"款");
			cost.setDescr("芭啦芭啦樱之花第"+ i +"式");
			dao.save(cost);
		}
	}
	@Test
	public void testUpdate(){
		Cost cost = dao.findById(141);
		cost.setName("234计时");
		dao.update(cost);
	}
	@Test
	public void testDelete(){
		Cost cost = dao.findById(184);
		dao.delete(cost.getCost_id());
	}
}
