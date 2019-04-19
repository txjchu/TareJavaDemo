package day02.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader转换字符流
 * 1.可以将字节流转换为字符流
 * 2.可以设置转换的字符集
 * @author Administrator
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
					//编码集的设置要与输出流相符，才能正确获取到读入的数据。
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//包装字节流，并设置编码集
		int c = -1;//设置read方法的初始值
		while((c = isr.read()) != -1){
			System.out.print((char)c);//输出为char类型
		}
		isr.close();//关闭流
	}
}












