package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream
 * 高级流，功能是可以读取一组字节，然后将其还原为对应的对象(对象的反序列化)。
 * 需要注意的是，读取的这一组字节必须是由
 * ObjectOutputStream的writeObject方法序列化对象得到的。
 * @author Administrator
 *
 */
public class OISDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis
			= new FileInputStream("person.obj");
		
		ObjectInputStream ois				//-----高级流。【关闭高级流就关闭了低级流】
			= new ObjectInputStream(fis);
		/*
		 * Object readObject()
		 * 反序列化方法-------------------【对象的序列化和反序列化即可以使java文件实现存档】
		 */
		Person p=(Person)ois.readObject();
		
		System.out.println(p);
		
		ois.close();
		
	}
}
