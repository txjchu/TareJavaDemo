package org.tarena.note.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ���ڲ������е��������Ķ���	�Ĺ�����
 * @author Administrator
 *
 */
public class SpringTest {
	
	public static ApplicationContext getContext(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		return ac;
	}

}
