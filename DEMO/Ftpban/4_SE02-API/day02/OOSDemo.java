package day02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * java.io.ObjectOutputStream
 * 高级流，作用是可以将任何java对象转换为一组字节
 * 后通过其处理的流写出。
 * 
 * @author Administrator
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException {
		//将一组字节写入到文件中
		FileOutputStream fos
			= new FileOutputStream(
				"person.obj"	
			);
		//将给定的对象转换为一组字节
		ObjectOutputStream oos
			= new ObjectOutputStream(fos);
		
		Person p = new Person();
		p.setName("苍老师");
		p.setAge(30);
		p.setGender("女");
		
		List<String> otherInfo
			= new ArrayList<String>();
		otherInfo.add("是个演员");
		otherInfo.add("爱写毛笔字");
		otherInfo.add("促进中日文化交流");
		
		p.setOtherInfo(otherInfo);
		
		System.out.println(p);
		/*
		 * void writeObject(Object obj)
		 * 该方法会将给定的对象转换为一组字节，然后
		 * 通过其处理的流写出。
		 * 这里oos处理的流是fos,所以该方法将转换
		 * 后的字节通过fos就写入到文件中了。
		 * 
		 * 将字节写入硬盘的过程称为:持久化
		 */
		oos.writeObject(p);
		
		oos.close();
	}
}









