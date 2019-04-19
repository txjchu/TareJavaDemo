package day02.case02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * 案例测试
 * @author Administrator
 *
 */
public class TestCase {
	@Test//案例1	测试FOS的覆盖写入和追加写入
	public void testFOS() throws IOException{
		//覆写模式
		FileOutputStream fos = new FileOutputStream("fos.dat");
		String str = "HelloWorld";
		byte[] b = str.getBytes();//将字符串转换为byte型数组，每一个元素即一个int型值，
		fos.write(b);//写入byte数组的每一个元素，即写入每一个Int值的低八位，正好是byte值。
		//追加模式
		fos = new FileOutputStream("fos.dat", true);//追加模式的构造方式
		fos.write(b);//追加写入
		fos.close();
	}
	
	@Test//案例2	测试FIS读取文件
	public void testFIS() throws IOException{
		FileInputStream fis = new FileInputStream("fos.dat");
		int a = -1;
		while((a = fis.read()) != -1){
			System.out.print((char) a );//将独到的字节按照char字符型输出
		}
		fis.close();
	}
	
	@Test//案例3	测试FIS和FOS中的read()和writer()方法实现文件的复制
	public void testCopyFile1() throws IOException{
		FileInputStream fis = new FileInputStream(new File("fos.dat"));
		FileOutputStream fos = new FileOutputStream("fos_copy1.dat");
		int a = -1;
		while((a = fis.read()) != -1){//没有读取到文件末尾
			fos.write(a);
		}
		System.out.println("复制完毕1！");
		fis.close();
		fos.close();
	}
	@Test
	public void testCopyFile2() throws IOException{
		FileInputStream fis = new FileInputStream("fos.dat");
		FileOutputStream fos = new FileOutputStream(new File("fos_copy2.dat"));
		int a = -1;
		byte[] b = new byte[50];
		while((a = fis.read(b)) != -1){
			fos.write(b);
		}
		System.out.println("复制完毕2！");
		
		fis.close();
		fos.close();
	}
	
	@Test//案例4	测试基于缓存的复制文件操作
	public void testBISAndBOS() throws IOException{
		//创建缓存输入流
		FileInputStream fis = new FileInputStream("fos.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		//创建缓存输出流
		FileOutputStream fos = new FileOutputStream("fos_copy3.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int len = -1;
		while((len = bis.read()) != -1){
			bos.write(len);//通过缓存方式写入
		}
		System.out.println("复制完毕3！");
		bos.close();
		bis.close();
	}
	
	@Test//案例5	测试对象流OOS和OIS的序列化和反序列化
	public void testOOS() throws IOException, Exception{
		//创建对象输出流
		FileOutputStream fos = new FileOutputStream("emp.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Emp emp = new Emp("张三", 22, "女", 2222.2);
		oos.writeObject(emp);
		System.out.println("序列化完毕！完成持久化");
		//创建对象输入流
		FileInputStream fis = new FileInputStream("emp.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		if(obj instanceof Emp){
			System.out.println((Emp) obj);
		}
		System.out.println("反序列化完毕！");
		oos.close();
		ois.close();
	}
	
	@Test//案例6	按照指定字符集将内容写入文件	
	public void testOSW() throws IOException{
		//创建字符输出流
		FileOutputStream fos = new FileOutputStream("osw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		String str = "Mr张";
		osw.write(str);
		System.out.println("写入完毕！");
		osw.close();
		
	}
	
	@Test//案例7	测试字符输入流按照指定编码集读取文件的方法
	public void testISR() throws IOException{
		//创建字符输入流
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		int len = -1;
		while((len = isr.read()) != -1){
			System.out.print((char)len);//转换为字符型输出
		}
		System.out.println("读取完毕！");
		isr.close();
	}
}










