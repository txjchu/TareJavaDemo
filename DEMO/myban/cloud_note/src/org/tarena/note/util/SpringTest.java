package org.tarena.note.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用于测试类中调用容器的对象	的工具类
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
