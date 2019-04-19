package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * ��main��������
	 * @param args 
	 */
	public static void main(String[] args) {
		//----���������������������ļ�
		ApplicationContext ac = 		
			new ClassPathXmlApplicationContext("scope/applicationContext.xml");
		
		//������Ĭ������£�ÿһ��bean�Ķ���ᴴ��һ����Ӧ��ʵ����
		SomeBean sb1 = ac.getBean("someBean1",SomeBean.class);		
		SomeBean sb2 = ac.getBean("someBean1",SomeBean.class);	//��������Ϊ����ʱ������getBean�ͻᴴ������bean��
		
		System.out.println(sb1 == sb2);
		
	}

}
