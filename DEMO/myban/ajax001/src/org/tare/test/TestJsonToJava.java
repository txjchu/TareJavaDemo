package org.tare.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.tare.entity.Friend;

/**
 * 测试Json对象与Java对象的转换
 * @author Administrator
 *
 */
public class TestJsonToJava {

	//java对象转换为json对象
	@Test
	public void test1(){
		Friend f = new Friend();
		f.setName("lilei");
		f.setAge(19);
		System.out.println(f);
		JSONObject jsonObj = JSONObject.fromObject(f);
		String jsonStr = jsonObj.toString();
		System.out.println(jsonStr);
	}
	//java数组集合转变为json字符串
	@Test
	public void test2(){
		List<Friend> fs = new ArrayList<Friend>();
		for(int i = 0; i < 3; i ++){
			Friend f = new Friend();
			f.setName("Zoro"+ i);
			f.setAge(18 + i);
			fs.add(f);
		}
		JSONArray jsonArr = JSONArray.fromObject(fs);
		String jsonStr = jsonArr.toString();
		System.out.println(jsonStr);
	}
	//将JSON字符串转变为java对象
	@Test
	public void test3(){
		String jsonStr = "{\"name\":\"Luffy\",\"age\":18}";
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		Friend f = (Friend) JSONObject.toBean(jsonObj, Friend.class);
		System.out.println(f);
	}
	//将JSON数组形式字符串转变为java对象
	@Test
	public void test4(){
		String jsonStr = "[{\"name\":\"Luffy\", \"age\": 18}, {\"name\":\"Zoro\", \"age\":19}]";
		JSONArray jsonArr = JSONArray.fromObject(jsonStr);
		List<Friend> fs = (List<Friend>) JSONArray.toCollection(jsonArr, Friend.class);
		System.out.println(fs);
	}
}
