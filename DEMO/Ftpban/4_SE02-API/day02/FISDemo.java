package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * �ļ��ֽ�����������һ���ͼ�����
 * ���Խ����ݴ��ļ��ж�ȡ������
 * @author Administrator
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream(
				"fos.txt"
			);
		
		byte[] data = new byte[60];
		int len = fis.read(data);
		
		String str = new String(
			data,0,len,"GBK"
		);
		
		System.out.println(str);
		
		fis.close();
	}
}






