package day03.copy;



/**
 * �׳��쳣
 * throw�ؼ��ֿ��������׳�һ���쳣��ʵ����
 * ͨ��������������ǻ������򷽷����׳�һ���쳣��
 * 1.��ǰ���벻�����쳣�Ĵ������������⣬֪ͨ�����߳����ˡ���
 * 2.����һ�������﷨Ҫ�󣨼�û�б�����󣩣����ǲ�����ҵ���߼�Ҫ��ʱ��
 *  
 * @author Administrator
 *
 */
public class ExceptionDemo03 {
	public static void main(String[] args) {
		Person p = new Person();
		try{
			/*
			 * ������һ������throws�����׳�����쳣�ķ���ʱ�����������ڱ����������л������ǵ��ø÷���ʱ�Ƿ�
			 * �д����쳣���ֶΣ������ֶ������֣�
			 * 1.ʹ��try-catch���񲢴�����쳣
			 * 2.�ڵ�ǰ�����ϼ���ʹ��throws�׳����쳣��
			 * ������Զ��Ҫ��main����������throws��
			 */
			p.setAge(213);
		}catch(ageException e){
			System.out.println("ץ��һ��ageException");
			System.out.println(e.getMessage());
			/*
			 * ��������
			 * ץ��һ��ageException
			 * ��������������
			 */
		}catch(Exception e){
			System.out.println("�ӵ��õķ����в���һ���쳣!");
		}
		System.out.println("�����ǣ�"+ p.getAge());//�����ǣ�0
	}
}
















