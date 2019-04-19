package day05.copy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 贴吧测试hashcode()方法与equals()方法一同重写后，set集合存入元素的表现。
 * @author Administrator
 *
 */
public class TestHashCode {
	public static void main(String[] args) {
		Set<Student> set = new HashSet();
		set.add(new Student("lisi1", 20));
		set.add(new Student("lisi2", 22));
		set.add(new Student("lisi1", 20));
		set.add(new Student("lisi2", 22));
		set.add(new Student("lisi1", 20));
//		for(Iterator it = set.iterator(); it.hasNext();){
//			System.out.println(it.next());
//		}
		Iterator it = set.iterator();//创建迭代器
		for(Student s : set){
			System.out.println(s.toString());
		}
	}
}

//学生类
class Student{
	private String name;
	private int age;
	public Student(String name, int age) {//自动生成构造方法
		super();
		this.name = name;
		this.age = age;
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
	@Override
	public int hashCode() {//自动生成的hashCode方法，name,age相关
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {//自动生成equals方法，name,age相关
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {		
		return "["+ name +","+ age +"]";
	}
	
	
}








