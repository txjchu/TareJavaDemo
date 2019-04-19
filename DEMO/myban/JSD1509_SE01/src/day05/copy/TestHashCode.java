package day05.copy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ���ɲ���hashcode()������equals()����һͬ��д��set���ϴ���Ԫ�صı��֡�
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
		Iterator it = set.iterator();//����������
		for(Student s : set){
			System.out.println(s.toString());
		}
	}
}

//ѧ����
class Student{
	private String name;
	private int age;
	public Student(String name, int age) {//�Զ����ɹ��췽��
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
	public int hashCode() {//�Զ����ɵ�hashCode������name,age���
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {//�Զ�����equals������name,age���
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








