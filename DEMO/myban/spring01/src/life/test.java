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
//		LifeBean lb = ac.getBean("LifeBean",LifeBean.class);	//----��ȡһ��bean��ʵ��
//		
//		
//		lb.service();
		
		//�ر�������.close()��������������������
//		AbstractApplicationContext ac =
//			new ClassPathXmlApplicationContext("life/applicationContext.xml");
//		//�ر�������----�ر�������ʱ����ȵ���destroy���ٷ�����
//		ac.close();
//		
		
		
	}

}
