package day02.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象流：反序列化字节输入流
 * java.io.ObjectInputStream
 * @author Administrator
 *
 */
public class OISDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("person.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
//		Person per = (Person) ois.readObject();
		Object obj = ois.readObject();
		Person p = null;
		if(obj instanceof Person){
			p = (Person) obj;
		}
		System.out.println(p);
		
		ois.close();
	}
}












