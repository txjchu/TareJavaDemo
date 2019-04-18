package entity;

public class Student {
	private Integer id;
	private String name;
	private int age;
	@Override
	public String toString() {
		return "Student [age=" 
		+ age + ", id=" + id + ", name=" 
		+ name + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
}
