package org.tarena.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ognl.Ognl;
import ognl.OgnlException;

import org.junit.Test;
import org.tarena.entity.Emp;

/**
 * ����ognl.jar����
 */
public class TestOgnl {
	@Test//���Է�������
	public void test6() throws OgnlException{
		Map parameters = new HashMap();
		parameters.put("ename", "rose");
		parameters.put("eno", 20);
		//��ȡrose����ͳһ�ɴ�д��ʽ��ʾ
		Object root = null;
		Object value = Ognl.getValue(
			"#ename.toUpperCase()", parameters,root);
		System.out.println(value);
	}
	
	
	@Test//���Դ�Map��ȡֵ,����������ֵ
	public void test5() throws Exception{
		Map parameters = new HashMap();
		parameters.put("ename", "����");
		parameters.put("eno", 20);
		//��ȡ������Ϣ��Emp�������Ը�ֵ
		//��̬����һ��Emp����
		Class cls = 
			Class.forName("org.tarena.entity.Emp");
		Object obj = cls.newInstance();
		//���Map��key��obj����������һ�¾�����ֵ
		Set<String> keys = parameters.keySet();
		for(String key:keys){
			//��ȡparameters��key��Ӧ��valueֵ
			Object value = 
				BeanUtil.getProperty(parameters, key);
			//��obj����key��������valueֵ
			BeanUtil.setProperty(obj, key, value);
		}
		//������,��obj��ԭΪEmp�鿴��Ϣ�Ƿ���ܵ�
		Emp emp = (Emp)obj;
		System.out.println(emp.getEname());
		System.out.println(emp.getEno());
	}
	
	@Test
	public void test4() throws OgnlException{
		Map context = new HashMap();
		context.put("ename", "����");
		context.put("eno", 5);
		Emp root = new Emp();
		root.setEname("scott");
		root.setEno(1);
		Object value = 
			Ognl.getValue("#ename", context,root);
		System.out.println(value);
	}
	
	
	@Test//���Ի�ȡMap��Ϣ
	public void test3(){
		Map data = new HashMap();
		data.put("ename", "����");
		data.put("eno", 5);
		Object value = 
			BeanUtil.getProperty(data, "ename");
		System.out.println(value);
	}
	
	//��������ֵ
	@Test
	public void test2(){
		Emp emp = new Emp();
		BeanUtil.setProperty(emp, "ename", "tom");
		BeanUtil.setProperty(emp, "eno", 2);
		System.out.println(emp.getEname());
		System.out.println(emp.getEno());
	}

	//����ȡֵ
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
