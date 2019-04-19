package day03;
/**
 * set-get����ʹ���е�����˽�л����������л���
 * @author Administrator
 *
 */
public class Emp {
	private String name;
	private int age;
	private String gender;
	private double salary;
	public Emp(String name, int age, String gender, double salary) {
		super();
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
	
	public String toString(){
		return name+","+age+","+gender+","+salary+",";
	}
	
	/**
	 * ��дequals()�ȽϷ���������ԭ��
	 * 1.null���κζ���Ƚϣ���Ϊfalse;
	 * 2.Ԫ��������Ƚϣ���Ϊtrue;
	 * 3.����������ͬһ����Ķ���Ƚ�ʱ������false��
	 */
	public boolean equals(Object o ){
		if(o==null){
			return false;
		}
		if(o==this){
			return true;
		}
		if(o instanceof Emp){
			Emp e = (Emp)o;
			return e.name.equals(this.name);//����Ҫ��equals�Ƚ������ַ���
		}
		return false;
		}				
}
