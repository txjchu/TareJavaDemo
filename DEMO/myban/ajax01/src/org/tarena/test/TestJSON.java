package org.tarena.test;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.tarena.entity.User;
import org.tarena.entity.User1;

public class TestJSON {
	
	//将一个User对象转成JSON字符串
	//{"id":1,"name":"soctt"}
	@Test
	public void test(){
		User user = new User();
		user.setId(1);
		user.setName("scott");
		
		JSONObject json = JSONObject.fromObject(user);
		String str = json.toString();
		System.out.println(str);
	}
	@Test
	public void test3(){
//		System.out.println(json1);
		
		List<User1> list1 = new ArrayList<User1>();
		User1 user3 = new User1();
		user3.setId(3);
		user3.setName("唐僧");
		
		User1 user4 = new User1();
		user4.setId(4);
		user4.setName("八戒");
		
		list1.add(user3);
		list1.add(user4);
		
		JSONArray json1 = JSONArray.fromObject(list1);
		System.out.println(json1.toString());

		
	}
	
	//将一个List<User>集合转成JSON字符串
	@Test
	public void test2(){
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setId(1);
		user1.setName("tom");
		
		User user2 = new User();
		user2.setId(2);
		user2.setName("scott");
		
		list.add(user1);
		list.add(user2);
		//转换
		JSONArray json = JSONArray.fromObject(list);
		String str = json.toString();
		System.out.println(str);
	}
	
	
}
