package org.tarena.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ognl.Ognl;
import ognl.OgnlException;

import org.junit.Test;
import org.tarena.entity.Emp;

/**
 * 测试ognl.jar工具
 */
public class TestOgnl {
	@Test//测试方法调用
	public void test6() throws OgnlException{
		Map parameters = new HashMap();
		parameters.put("ename", "rose");
		parameters.put("eno", 20);
		//提取rose并且统一成大写格式显示
		Object root = null;
		Object value = Ognl.getValue(
			"#ename.toUpperCase()", parameters,root);
		System.out.println(value);
	}
	
	
	@Test//测试从Map中取值,给对象设置值
	public void test5() throws Exception{
		Map parameters = new HashMap();
		parameters.put("ename", "李四");
		parameters.put("eno", 20);
		//提取上述信息给Emp对象属性赋值
		//动态创建一个Emp对象
		Class cls = 
			Class.forName("org.tarena.entity.Emp");
		Object obj = cls.newInstance();
		//如果Map中key与obj对象属性名一致就设置值
		Set<String> keys = parameters.keySet();
		for(String key:keys){
			//获取parameters中key对应的value值
			Object value = 
				BeanUtil.getProperty(parameters, key);
			//给obj对象key属性设置value值
			BeanUtil.setProperty(obj, key, value);
		}
		//测试下,将obj还原为Emp查看信息是否接受到
		Emp emp = (Emp)obj;
		System.out.println(emp.getEname());
		System.out.println(emp.getEno());
	}
	
	@Test
	public void test4() throws OgnlException{
		Map context = new HashMap();
		context.put("ename", "张三");
		context.put("eno", 5);
		Emp root = new Emp();
		root.setEname("scott");
		root.setEno(1);
		Object value = 
			Ognl.getValue("#ename", context,root);
		System.out.println(value);
	}
	
	
	@Test//测试获取Map信息
	public void test3(){
		Map data = new HashMap();
		data.put("ename", "张三");
		data.put("eno", 5);
		Object value = 
			BeanUtil.getProperty(data, "ename");
		System.out.println(value);
	}
	
	//测试设置值
	@Test
	public void test2(){
		Emp emp = new Emp();
		BeanUtil.setProperty(emp, "ename", "tom");
		BeanUtil.setProperty(emp, "eno", 2);
		System.out.println(emp.getEname());
		System.out.println(emp.getEno());
	}

	//测试取值
	@Test
	public void test1(){
		Emp emp = new Emp();
		emp.setEname("scott");
		emp.setEno(1);
		Object value = 
			BeanUtil.getProperty(emp, "eno");
		System.out.println(value);
	}
	
}
