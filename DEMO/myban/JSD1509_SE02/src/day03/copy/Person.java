package day03.copy;
/**
 * ���ڸ��������쳣��throws
 * @author Administrator
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	
	/*
	 * throws�����ڷ����϶���÷��������׳����쳣����������Ŀ����֪ͨ�����߱���Ҫ��������׳����쳣��
	 * �ô��ǣ������߲�����Ϊ�÷����׳�һ���쳣��û�н�����³����жϡ�
	 * ʲôʱ����Ҫ�ڷ���������throws�׳��쳣��
	 * 1.��������ʹ��throw�׳�һ������쳣
	 * ����RuntimeException�����ࣩʵ��ʱ�����ǿ����ڷ������������쳣���׳�֪ͨ�����ߡ�
	 * 2.��ǰ����������һ������throws�����ķ���ʱ���÷�����Ȼ����������쳣ʱ�������ڵ�ǰ�����ϼ���ʹ��throws����
	 * ����쳣���׳���֪ͨ�ϲ�����߽����
	 */
	public void setAge(int age) throws ageException{
		if(age < 0 || age > 100){
			throw new ageException("��������������");
		}
		this.age = age;
	}
	
}



















