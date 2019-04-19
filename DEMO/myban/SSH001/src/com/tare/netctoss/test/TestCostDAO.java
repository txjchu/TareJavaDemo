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
 * �����࣬����CostDAO���еķ���
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
	public void testFindByName(){//���԰����ֲ��ң�����̬��֤�����Ƿ�Ψһ
		List<Cost> costs = dao.findByName("������19��");
		if(costs.size() != 0){
			for(Cost c : costs){
				System.out.println(c);
			}
						// actual ��ʵ��Ŀǰ�� 	expected Ԥ�ڵ�	positional λ�õ�λ�� 
		} else {
			System.out.println("���ֿ���ʹ�ã�û�б�ע�����");
		}
	}
	@Test
	public void testFindByPage(){
		int page = 3;//��ǰ�ڼ�ҳ
		int pageSize = 6;//ÿҳ��¼��
		System.out.println("�ܹ��У�"+ dao.findTotalPage(pageSize));
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
			cost.setName("������"+ i +"��");
			cost.setDescr("��������ӣ֮����"+ i +"ʽ");
			dao.save(cost);
		}
	}
	@Test
	public void testUpdate(){
		Cost cost = dao.findById(141);
		cost.setName("234��ʱ");
		dao.update(cost);
	}
	@Test
	public void testDelete(){
		Cost cost = dao.findById(184);
		dao.delete(cost.getCost_id());
	}
}
