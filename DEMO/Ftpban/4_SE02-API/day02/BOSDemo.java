package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲输出流写出数据的注意事项
 * @author Administrator
 *
 */
public class BOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("bos.txt");
		
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		
		String str = "我爱北京天安门";
		byte[] data = str.getBytes("UTF-8");
		/*
		 * 缓冲流的write方法也不会将给定的字节
		 * 马上写出，而是存入内部缓冲区(字节数组)
		 * 只有缓冲区满了，才会一次性写出。
		 */
		bos.write(data);
		/*
		 * 若我们需要将在缓冲区中的数据一次性写出
		 * 时，可以调用flush，该方法比较强制，会将
		 * 缓冲区中现有的数据一次性写出。
		 * 但要知道，频繁的调用该方法会提高写出次数，
		 * 降低写出效率，但是带来的效果是写出的即时性
		 * 提高了。
		 */
		bos.flush();
		//关闭前会自动调用一次flush
		bos.close();
	}
}









