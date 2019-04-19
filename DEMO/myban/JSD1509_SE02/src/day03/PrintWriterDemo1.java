package day03;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter
 * 具有自动行刷新功能的缓冲字符输出流
 * 缓冲字符流的特点是可以以行为单位读写字符串。
 * 
 * PrintWriter在创建时内部会自动包装一层BufferedWriter作为缓冲功能。
 * 其自身又具备自动行刷新，所以实际开发中也比较常用。
 * @author Administrator
 *
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * 直接向文件进行写操作的构造方法。
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 */
		PrintWriter pw=new PrintWriter("pw.txt");//支持2个参数，指定字符集：可以加"UTF-8"	//---可以直接操作文件，但是所有的字符流都是高级流。
		
		pw.println("摩擦摩擦");
		pw.println("是魔鬼的步伐");
		pw.println("是老妖怪来啦");
		pw.println("是广场舞大妈");//共52个字节，4个换行符是8个字节。
		
		pw.close();
		
		
	}
}
