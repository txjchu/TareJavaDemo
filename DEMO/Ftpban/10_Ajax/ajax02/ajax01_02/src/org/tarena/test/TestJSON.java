package org.tarena.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.tarena.entity.User;

public class TestJSON {

	//��һ��User����ת��JSON�ַ���
	//{"id":1,"name":"scott"}
	@Test
	public void test1(){
		User user = new User();
		user.setId(1);
		user.setName("scott");
		
		JSONObject json = 
			JSONObject.fromObject(user);
		String str = json.toString();
		System.out.println(str);
	}
	
	//��һ��List<User>����ת��JSON�ַ���
	//[{"id":1,"name":"tom"},{"id":2,"name":"scott"}]
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
		//ת��
		JSONArray json = 
			JSONArray.fromObject(list);
		String str = json.toString();
		System.out.println(str);
	}
	
	
	
}
