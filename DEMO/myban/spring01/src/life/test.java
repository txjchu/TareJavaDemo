package life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("life/applicationContext.xml");
//		
//		LifeBean lb = ac.getBean("LifeBean",LifeBean.class);	//----获取一个bean的实例
//		
//		
//		lb.service();
		
		//关闭容器的.close()方法在这个类型里面才有
//		AbstractApplicationContext ac =
//			new ClassPathXmlApplicationContext("life/applicationContext.xml");
//		//关闭容器。----关闭容器的时候会先调用destroy销毁方法。
//		ac.close();
//		
		
		
	}

}
