package dao;

import java.util.ArrayList;
import java.util.List;

import entity.City;
import entity.Customer;

/**
 * 顾客DAO模拟有关顾客的数据操作
 * @author Administrator
 *
 */
public class CustomerDAO {
	
	/*
	 * 模拟根据id查询出顾客信息。
	 */
	public Customer findById(){
		Customer c = new Customer();
		c.setName("tare");
		c.setPassword("123");
		c.setMarry(true);
		c.setDesc("万里长城长又长");
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
		c1.setName("武汉");
		City c2 = new City();
		c2.setCode("nanjing");
		c2.setName("南京");
		City c3 = new City();
		c3.setCode("hangzhou");
		c3.setName("杭州");
		City c6 = new City();
		c6.setCode("shanghai");
		c6.setName("上海");
		City c4 = new City();
		c4.setCode("beijing");
		c4.setName("北京");
		City c5 = new City();
		c5.setCode("guangzhou");
		c5.setName("广州");
		City c7 = new City();
		c7.setCode("shenzhen");
		c7.setName("深圳");
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
