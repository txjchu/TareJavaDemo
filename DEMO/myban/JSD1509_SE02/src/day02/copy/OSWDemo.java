package day02.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * OutputStreamWriter输出字符转换流
 * @author Administrator
 *
 */
public class OSWDemo {	
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//设置字符集
		osw.write("我爱北京天安门，");
		osw.write("摩擦摩擦似魔鬼的步伐，");
		osw.write("一步两步，");
		osw.write("发现更大的世界。");
		osw.close();
		
	}
}












