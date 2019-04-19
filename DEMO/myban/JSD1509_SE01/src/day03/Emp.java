package day03;
/**
 * set-get方法使类中的数据私有化，方法公有化。
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
	 * 重写equals()比较方法的三个原则：
	 * 1.null与任何对象比较，都为false;
	 * 2.元素与自身比较，恒为true;
	 * 3.两个不属于同一个类的对象比较时，返回false。
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
			return e.name.equals(this.name);//这里要用equals比较两个字符串
		}
		return false;
		}				
}
