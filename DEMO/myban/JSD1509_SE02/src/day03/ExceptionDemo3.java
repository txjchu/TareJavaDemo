package day03;
/**
 * �׳��쳣
 * throw�ؼ��ֿ��������׳�һ���쳣��ʵ��
 * ͨ��������������ǻ������򷽷����׳�һ���쳣��
 * 1.��ǰ���벻�����쳣����(���������⣬֪ͨ�����߳�����)
 * 2.������һ�������﷨Ҫ�󣬵��ǲ�����ҵ���߼�Ҫ��ʱ��
 * @author Administrator
 *
 */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		Person p=new Person();
		try {
			/*
			 * ������һ������throws�����׳�����쳣�ķ���ʱ���������ڱ�����������
			 * �������ǵ��ø÷���ʱ�Ƿ��д����쳣���ֶΣ������ֶ������֣�
			 * 1.ʹ��try-catch ���񲢴�����쳣��
			 * 2.�ڵ�ǰ�����ϼ���ʹ��throws�׳����쳣��
			 * 
			 */
			
			p.setAge(291);
		} catch (IllegalAgeException e) {
		
			e.printStackTrace();
		}
		System.out.println("�����ǣ�"+p.getAge());
		
		
		
		
	}
	
	
}
