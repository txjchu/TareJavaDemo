package day07.copy;
/**
 * �����ʾXML�ĵ���һ��Ա����Ϣ��
 * @author Administrator
 *
 */
public class Emp {
	private int id;
	private String name;
	private int age;
	private String gender;//�Ա�
	private int salary;//����
	//���췽��
	public Emp(int id, String name, int age, String gender, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String toString(){
		return id +","+ name +","+ age +","+ gender +","+ salary;  
	}
	
}
