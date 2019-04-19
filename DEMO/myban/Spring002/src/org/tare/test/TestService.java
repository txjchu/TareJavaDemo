package org.tare.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tare.service.DeptService;

import com.sun.xml.internal.ws.wsdl.writer.document.Service;

/**
 * ���Գ־ò��ҵ��������ע��IOC
 * @author Administrator
 *
 */
public class TestService {
	
	@Test
	public void test(){
		String conf = "org/tare/service/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DeptService service = ac.getBean("deptService", DeptService.class);
		service.addDept();
		service.updateDept();
		service.deleteDept();
		
	}
}
