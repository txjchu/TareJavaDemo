package dao;

import java.util.ArrayList;
import java.util.List;

import entity.City;
import entity.Customer;

/**
 * �˿�DAOģ���йع˿͵����ݲ���
 * @author Administrator
 *
 */
public class CustomerDAO {
	
	/*
	 * ģ�����id��ѯ���˿���Ϣ��
	 */
	public Customer findById(){
		Customer c = new Customer();
		c.setName("tare");
		c.setPassword("123");
		c.setMarry(true);
		c.setDesc("���ﳤ�ǳ��ֳ�");
		c.setSex("M");
		c.setHome("beijing");
		List<String> cities = new ArrayList<String>();
		cities.add("beijing");
		cities.add("guangzhou");
		cities.add("hangzhou");
		cities.add("shenzhen");
		c.setTravelCities(cities);
		return c;		
	}
	public List<City> findAllCities(){
		List<City> cs = new ArrayList<City>();
		City c1 = new City();
		c1.setCode("wuhan");
		c1.setName("�人");
		City c2 = new City();
		c2.setCode("nanjing");
		c2.setName("�Ͼ�");
		City c3 = new City();
		c3.setCode("hangzhou");
		c3.setName("����");
		City c6 = new City();
		c6.setCode("shanghai");
		c6.setName("�Ϻ�");
		City c4 = new City();
		c4.setCode("beijing");
		c4.setName("����");
		City c5 = new City();
		c5.setCode("guangzhou");
		c5.setName("����");
		City c7 = new City();
		c7.setCode("shenzhen");
		c7.setName("����");
		cs.add(c1);
		cs.add(c2);
		cs.add(c3);
		cs.add(c4);
		cs.add(c5);
		cs.add(c6);
		cs.add(c7);
		return cs;
	}
}
