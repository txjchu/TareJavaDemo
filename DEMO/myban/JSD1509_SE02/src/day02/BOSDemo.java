package day02;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
		String str="我爱北京天安门";
		byte[] data=str.getBytes("UTF-8");
		/*
		 * 缓冲流的write方法也不会将给定的字节马上写出，
		 * 而是存入内部缓冲区（字节数组），只有缓冲区满了，才会一次性写出。
		 */
		bos.write(data);
		/*
		 * 若我们需要将在缓冲区中的数据一次性写出时，可以调用flush方法，该方法比较强制，
		 * 会将缓冲区中现有的数据一次性写出。
		 * 但是要知道，频繁的调用该方法会提高写出次数，降低写出效率，但是带来的效果是
		 * 写出的及时性提高了。
		 */
		bos.flush();
		
		bos.close();
		
	}
}
