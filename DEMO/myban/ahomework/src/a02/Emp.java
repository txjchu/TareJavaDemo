package a02;
/**
 * day01_c01_Emp 
 * @author Administrator
 *
 */
public class Emp {
	String name;//����
	int age;//����
	char gender;//�Ա�
	double salary;//����
	public void printInfo(Emp emp){//��ӡԱ����Ϣ�ķ���
		System.out.println("--------------");
		System.out.println("������"+ emp.name);
		System.out.println("���䣺"+ emp.age);
		System.out.println("�Ա�"+ emp.gender);
		System.out.println("���ʣ�"+ emp.salary);
	}
}
