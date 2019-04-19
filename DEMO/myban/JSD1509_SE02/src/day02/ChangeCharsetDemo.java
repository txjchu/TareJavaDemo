package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * ×ª»¯×Ö·û¼¯
 * @author Administrator
 *
 */
public class ChangeCharsetDemo {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr
			= new InputStreamReader(
					new FileInputStream("osw.txt"),"UTF-8");
		
		OutputStreamWriter osw
			= new OutputStreamWriter(
					new FileOutputStream("osw_gdk.txt"),"GBK");
		
		int d=-1;
		try {
			while((d = isr.read()) != -1){
				System.out.print((char)d);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			isr.close();
			osw.close();
		}
		
		
	}
}
