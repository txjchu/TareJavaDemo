package day03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter
 * 具有自动行刷新功能的缓冲字符输出流
 * 缓冲字符流的特点是可以以行为单位读写字符串。
 * 
 * PrintWriter在创建是内部会自动包装一层
 * BufferedWriter作为缓冲功能。其自身又具备
 * 自动行刷新，所以实际开发中也比较常用。
 * @author Administrator
 *
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 直接向文件进行写操作的构造方法
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 */
		PrintWriter pw 
			= new PrintWriter("pw.txt","UTF-8");
		
		pw.println("摩擦摩擦");
		pw.println("是魔鬼的步伐");
		pw.println("是老妖怪来啦");
		pw.println("是广场舞大妈");
		
		pw.close();
	}
}







