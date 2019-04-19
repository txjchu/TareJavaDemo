package day02.homeWork;

import org.junit.Test;

/**
 * ��ҵ�ڶ���
 * value object
 * @author Administrator
 *
 */
public class Emp {
	private String name;
	private int age;
	private String gender;
	private double salary;
	
	//���췽��
	public Emp(String name, int age, String gender, double salary){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	/** ��ӡ��Ϣ�ķ��� */
	public void paintInfo(){
		System.out.println("-----------");
		System.out.println("������"+ name);
		System.out.println("���䣺"+ age);
		System.out.println("�Ա�"+ gender);
		System.out.println("���ʣ�"+ salary);
	}
	
	@Override
	/** ��дequals()���� */
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Emp){
			Emp emp = (Emp) obj;//ǿת����
//			return this.name == emp.name;========����
			return this.name.equals(emp.name);//�˴�����String��equals()����
		}else{
			return false;
		}
	}

	@Override
	/** ��дtoString()���� */
	public String toString() {
		return name +","+ age +","+ gender +","+ salary;
	}
	
}

/** ������ */
class testEmp1{
	
	public static void main(String[] args) {
		Emp emp1 = new Emp("����", 22, "��", 3333);
		
	}
	
	//����
	@Test
	public void testPaintInfo(){
		Emp emp1 = new Emp("����", 22, "��", 3333);
		emp1.paintInfo();
	}
}











