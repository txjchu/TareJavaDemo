package day01.Case;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 案例练习
 * @author Administrator
 *
 */
public class Case {
	
	
	@Test//案例1		输出当前目录下的所有文件
	public void testFile(){
		File dir = new File(".");//设定路径为当前目录
		File[] files = dir.listFiles();
		for(File file : files){
			System.out.println(file.getName() +" : "+ file);
		}
	}
	
	@Test//案例2		输出当前目录下所有txt文件
	public void testListfile(){
		File dir = new File(".");
		File[] files = dir.listFiles(new FileFilter(){//创建文件选择器,匿名类
			@Override
			public boolean accept(File f) {//重写选择方法				
				return f.getName().endsWith(".txt");
			}
		});
		for(File file : files){//新循环遍历文件集合
			System.out.println(file);
		}
	}
	
	@Test//案例3		测试raf的read和write方法
	public void testRandomAccessFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		/**
		 * 根据测试指针操作的几种方法，得出结论：
		 * read和write方法后，文件指针会处于下1个字节处待命。
		 */
		//写入数字1，写入的是int数的低八位
//		raf.write(new byte[]{0, 1, 2});
		raf.write(1);
//		raf.seek(0);
		System.out.println("此时光标所在位置："+ raf.getFilePointer() +"，read方法返回值为："+ raf.read());
		raf.close();
		RandomAccessFile raf1 = new RandomAccessFile("raf.dat", "r");
//		System.out.println(raf1.getFilePointer());
//		int a = raf1.read(), b = raf1.read(), c = raf1.read();		
//		System.out.println("此时光标所处的位置："+ raf1.getFilePointer() + "，read读取到的数字:"+ c);//输出
		int i = raf1.read();
		System.out.println("此时光标所处的位置："+ raf1.getFilePointer() + "，read读取到的数字:"+ raf1.read());
		raf1.close();
	}
	
	@Test//案例4		多字节读取或写入测试  
	public void testWriteByteArray() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		byte[] buf = "HelloWorld".getBytes();//将字符串转换为byte数组
		raf.write(buf);
		raf.close();
	}
	@Test
	public void testReadByteArray() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		byte[] buf = new byte[10];//创建一个10字节大小的byte数组
		int len = raf.read(buf);//读取buf大小的字节，并返回实际读取到的字节数
		System.out.println(Arrays.toString(buf));//将buf输出:[72, 101, 108, 108, 111, 87, 111, 114, 108, 100]
		System.out.println("实际读取到了："+ len +"个字节，"+ new String(buf));//HelloWorld
		raf.close();
	}
	
	@Test//案例5		测试文件指针
	public void testPointer() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		long a = raf.getFilePointer();
		System.out.println("当前指针位置为："+ a);//当前指针的位置为：0
		int skip = raf.skipBytes(5);//将指针后移跳过n个字节
		System.out.println("跳过5个字节后指针位置为："+ raf.getFilePointer());//跳过5个字节后指针位置为：5
		byte[] buf = new byte[5];
		int len = raf.read(buf);//读取byte数组长度个字节，返回实际跳过的字节数
		System.out.println("现在读取了"+ len +"个字节，读到的字节为："+ new String(buf));//现在读取了5个字节，读到的字节为：World
		raf.seek(0);//将指针移到n下标上
		System.out.println("当前指针的位置为："+ raf.getFilePointer());//当前指针的位置为：0
		raf.close();
	}
	
	
	@Test
	public void testCount(){
		int a = 1;
		int b = a;
		b = b + 1;
		System.out.println(a +","+ b);
		
		int flag = 0;
		for(int i = 0; i < 10; i ++){
			System.out.print(flag +";");//当进入第二次循环时，为什么flag又变回0？？？因为v（下面）
			count(flag);
			System.out.println(flag);//当count方法使用玩flag后，并没有将变化后的flag返回给当前的flag作用域使用，因此flag还是0.
		}
		System.out.println(flag);
	}
	void count(int i){
		i ++;
		System.out.print(i +" ");
	}
}









