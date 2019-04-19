package day02.Exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import day02.case02.Emp;

/**
 * 课后习题练习
 * @author Administrator
 *
 */
public class TestExercise {
	
	@Test//习题3	测试自定义的缓冲区读写方法--使用字节数组的形式移动文件
	public void testMoveFile1() throws IOException{
		//创建文件输出流和文件输入流对象
		FileInputStream fis = new FileInputStream("fos.dat");
		FileOutputStream fos = new FileOutputStream("src" +File.separator+ "fos_move.dat");
		int len = -1;
		byte[] buf = new byte[32];
		while((len = fis.read(buf)) != -1){
			fos.write(buf, 0, len);//使用3参数方法防止读取到文件末尾后写入多余的空字节。
		}
		System.out.println("文件移动完毕！");
		fis.close();
		fos.close();
	}
	
	@Test//习题4	使用缓冲字节流进行文件的移动
	public void testMoveFile2() throws IOException{
		//创建缓冲输入流和输出流对象
		FileInputStream fis = new FileInputStream("fos.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream("src"+ File.separator +"bfos_copy.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int a = -1;
		while((a = bis.read()) != -1){
			bos.write(a);//写出a
		}
		System.out.println("文件移动完毕2！");
		bis.close();
		bos.close();
	}
	
	@Test//习题5	测试对象流的写出方法，序列化对象
	public void testWriter() throws IOException{
		//创建对象字节输出流
		FileOutputStream fos = new FileOutputStream("empList.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		List<Emp> emps = new ArrayList<Emp>();
		emps.add(new Emp("张三", 22, "男", 3333.33));
		emps.add(new Emp("李四", 23, "女", 4444.55));
		emps.add(new Emp("王五", 24, "男", 5555.22));
		emps.add(new Emp("赵六", 25, "女", 4333.44));
		oos.writeObject(emps);//将对象序列化
		System.out.println("对象写入完毕，序列化完毕!");
		oos.close();
	}
	@Test//反序列化
	public void testReader() throws IOException, ClassNotFoundException{
		//创建对象字节输入流
		FileInputStream fis = new FileInputStream("empList.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		int a = -1;
		List<Emp> emps = (List)ois.readObject();//反序列化
		for(Emp e : emps){
			System.out.println(e);
		}
		System.out.println("反序列化完毕，读入数据完毕！");
		ois.close();
	}
	
}











