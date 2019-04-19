package day03.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * java.io.PrintWriter
 * 具有自动行刷新功能的缓冲字符输出流
 * 
 * PrintWriter在创建时内部会自动包装一层。
 * BufferedWriter作为缓冲功能，其自身又具备自动行刷新，所以实际开发中也比较常用。
 * @author Administrator
 *
 */
public class PrintWriterDemo01 {
	public static void main(String[] args) throws IOException, IOException {
		/*
		 * 直接向文件进行写操作的构造方法
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 * 
		 */
		PrintWriter pw = new PrintWriter("pw.txt", "UTF-8");
		pw.println("摩擦摩擦");
		pw.println("似魔鬼的步伐");
		pw.print("是老妖怪来了");
		pw.print("是广场舞大妈");
		pw.close();
	}
}














